package creator

import java.util.List

class Table {
	@Property String name
	@Property List<Member> members
}

@Data class Member {
	String type
	String name
}
