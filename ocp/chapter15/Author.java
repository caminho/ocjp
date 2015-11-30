class Author {
    private int authorId;
    private String firstName;
    private String lastName;

	public Author() {}
	public Author(int id, String fName, String lName) {
		this.authorId = id;
		this.firstName = fName;
		this.lastName = lName;
	}

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

	public String toString() {
		return "(" + authorId + ", " + firstName + ", " + lastName + ")";
	}
}
