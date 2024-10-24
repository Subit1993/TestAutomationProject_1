package construct_POJO_Utility;



public class SetCustomerPojo {
	static ReadData readdata;
	private String customerId;
	private String contractId;
	private String geozone;
	private String teamcode;
	private String projectcode;
	private String buildduration;
	// String setValidData[] = ReadData.getDataFromSource();

	public void setcustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getcustomerId() {
		return customerId;
	}
	public void setcontractId(String contractId) {
		this.contractId = contractId;
	}

	public String getcontractId() {
		return contractId;
	}

	public String getTeamcode() {
		return teamcode;
	}

	public void setTeamcode(String teamcode) {
		this.teamcode = teamcode;
	}

	public String getGeozone() {
		return geozone;
	}

	public void setGeozone(String geozone) {
		this.geozone = geozone;
	}

	public String getBuildduration() {
		return buildduration;
	}

	public void setBuildduration(String buildduration) {
		this.buildduration = buildduration;
	}

	public String getProjectcode() {
		return projectcode;
	}

	public void setProjectcode(String projectcode) {
		this.projectcode = projectcode;
	}
}
