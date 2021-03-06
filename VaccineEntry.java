/**
 * VaccineEntry class models each entry in the Vaccine Record Table
 */
public class VaccineEntry {

	private String id;
	private String lastName;
	private String firstName;
	private String type;
	private String date;
	private String location;

	public VaccineEntry(String id, String lastName, String firstName, String type, String date, String location) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.type = type;
		this.date = date;
		this.location = location;
	}

    /* Getters and Setters */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String toString() {
		return id + "," + lastName + "," + firstName + "," + type + "," + date + "," + location + "\n";
	}
	public boolean equals(Object o) {
		return o.toString().equals(this.toString());
	}

}
