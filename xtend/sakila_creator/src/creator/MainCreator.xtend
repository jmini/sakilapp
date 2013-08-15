package creator 
import com.google.common.io.Files
import java.io.File
import com.google.common.base.Charsets
import java.util.List

class MainCreator {
	def static void main(String[] args) {
		val fileCnt = Files::toString(new File("../../sakila-db/sakila-schema.sql"), Charsets::UTF_8)
		val tableCnt = fileCnt.substring(0, fileCnt.indexOf("CREATE VIEW"))
		val tablesCnt = tableCnt.split("CREATE TABLE")
		
		val tables = tablesCnt.tail.map[it.handleTable].toList
		
		//Filter:
		tables.forEach[currentTable |
				currentTable.members = currentTable.members.filter[
					name != "lastUpdate" && 
					name != currentTable.name.toFirstLower + "Id"
				].map[m|
					if(m.type == "int" && m.name.endsWith("Id")) {
						val memberName = m.name.toFirstUpper
						val table = tables.findFirst[t| memberName.endsWith(t.name + "Id")]
						if(table != null) {
							val restName = memberName.replaceAll(table.name + "Id$", "")
							val className = (if(restName.empty) table.name else restName).toFirstLower
							return new Member(table.name, className)
						}
					}
					return m
				].toList
			]
		
		println(tables.printClass)
	}
	
	def static handleTable(String cnt) {
		val table = new Table
		
		val start = cnt.indexOf("(")
		val end = cnt.lastIndexOf(")")
		
		table.name = cnt.substring(0, start).trim.toFirstUpper
		val tableCnt = cnt.substring(start+1, end)
		
		table.members = tableCnt.split(",\n").map[trim].filter[
			return !(it.startsWith("KEY") 
				|| it.startsWith("PRIMARY KEY")
				|| it.startsWith("UNIQUE KEY")
				|| it.startsWith("FULLTEXT KEY")
				|| it.startsWith("CONSTRAINT")
			)
		].map[
			it.handleMember
		].toList
		
		return table
	}
	
	def static printClass(List<Table> tables) '''
		package sakila.bean
		«FOR table : tables»
		
		class «table.name.toCamelCase» {
		«FOR m : table.members»    @Property «m.type» «m.name»
		«ENDFOR»
		}
		«ENDFOR»
'''
	
	def static handleMember(String member) {
		val elements = member.split(" ")
		val name = elements.head
		val type = elements.tail.head
		new Member(type.mapToJava, name.toCamelCase.toFirstLower)
	}
	
	def static mapToJava(String string) {
		return switch string {
			case string.startsWith("VARCHAR") : "String"
			case string.startsWith("CHAR") : "String"
			case "TEXT" : "String"
			case "TINYINT" : "int"
			case "MEDIUMINT" : "int"
			case "SMALLINT" : "int"
			case "INT" : "int"
			case "YEAR" : "int"
			case string.startsWith("DECIMAL") : "double"
			case "TIMESTAMP" : "Date"
			case "DATETIME" : "Date"
			case "BOOLEAN" : "boolean"
			case "BLOB" : "Object"
			case string.startsWith("ENUM") : "Object /*shoud be an Enum instead of Object*/"
			case string.startsWith("SET") : "Set<Object> /*shoud be an Enum instead of Object*/"
			default : string
			}
	}
	
	def static toCamelCase(String string) {
		val e = string.split("_")
		val name = e.map[it.toFirstUpper].join
		return name
	}
	
}
