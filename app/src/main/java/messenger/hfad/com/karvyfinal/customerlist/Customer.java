package messenger.hfad.com.karvyfinal.customerlist;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Customer {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("customer_category")
    @Expose
    private String customerCategory;
    @SerializedName("customer_name")
    @Expose
    private String customerName;
    @SerializedName("salutation")
    @Expose
    private Object salutation;
    @SerializedName("contact_person_name")
    @Expose
    private String contactPersonName;
    @SerializedName("last_name")
    @Expose
    private Object lastName;
    @SerializedName("contact_number")
    @Expose
    private String contactNumber;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("employee_hcl_id")
    @Expose
    private String employeeHclId;
    @SerializedName("employee_karvy_id")
    @Expose
    private String employeeKarvyId;
    @SerializedName("employee_name")
    @Expose
    private String employeeName;
    @SerializedName("employee_email")
    @Expose
    private String employeeEmail;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("agreed_next_steps")
    @Expose
    private String agreedNextSteps;
    @SerializedName("follow_up_date")
    @Expose
    private String followUpDate;
    @SerializedName("outcome")
    @Expose
    private String outcome;
    @SerializedName("user_accompanied")
    @Expose
    private String userAccompanied;
    @SerializedName("pursued_acv_in_lakhs")
    @Expose
    private String pursuedAcvInLakhs;
    @SerializedName("signature_url")
    @Expose
    private String signatureUrl;
    @SerializedName("zone")
    @Expose
    private String zone;
    @SerializedName("region")
    @Expose
    private String region;
    @SerializedName("service_engagement_type")
    @Expose
    private String serviceEngagementType;
    @SerializedName("meeting_agenda_result")
    @Expose
    private String meetingAgendaResult;
    @SerializedName("employee_contact_number")
    @Expose
    private String employeeContactNumber;
    @SerializedName("employee_email_id")
    @Expose
    private String employeeEmailId;
    @SerializedName("visit_type")
    @Expose
    private String visitType;
    @SerializedName("customer_segment")
    @Expose
    private String customerSegment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerCategory() {
        return customerCategory;
    }

    public void setCustomerCategory(String customerCategory) {
        this.customerCategory = customerCategory;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Object getSalutation() {
        return salutation;
    }

    public void setSalutation(Object salutation) {
        this.salutation = salutation;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    public Object getLastName() {
        return lastName;
    }

    public void setLastName(Object lastName) {
        this.lastName = lastName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmployeeHclId() {
        return employeeHclId;
    }

    public void setEmployeeHclId(String employeeHclId) {
        this.employeeHclId = employeeHclId;
    }

    public String getEmployeeKarvyId() {
        return employeeKarvyId;
    }

    public void setEmployeeKarvyId(String employeeKarvyId) {
        this.employeeKarvyId = employeeKarvyId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAgreedNextSteps() {
        return agreedNextSteps;
    }

    public void setAgreedNextSteps(String agreedNextSteps) {
        this.agreedNextSteps = agreedNextSteps;
    }

    public String getFollowUpDate() {
        return followUpDate;
    }

    public void setFollowUpDate(String followUpDate) {
        this.followUpDate = followUpDate;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public String getUserAccompanied() {
        return userAccompanied;
    }

    public void setUserAccompanied(String userAccompanied) {
        this.userAccompanied = userAccompanied;
    }

    public String getPursuedAcvInLakhs() {
        return pursuedAcvInLakhs;
    }

    public void setPursuedAcvInLakhs(String pursuedAcvInLakhs) {
        this.pursuedAcvInLakhs = pursuedAcvInLakhs;
    }

    public String getSignatureUrl() {
        return signatureUrl;
    }

    public void setSignatureUrl(String signatureUrl) {
        this.signatureUrl = signatureUrl;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getServiceEngagementType() {
        return serviceEngagementType;
    }

    public void setServiceEngagementType(String serviceEngagementType) {
        this.serviceEngagementType = serviceEngagementType;
    }

    public String getMeetingAgendaResult() {
        return meetingAgendaResult;
    }

    public void setMeetingAgendaResult(String meetingAgendaResult) {
        this.meetingAgendaResult = meetingAgendaResult;
    }

    public String getEmployeeContactNumber() {
        return employeeContactNumber;
    }

    public void setEmployeeContactNumber(String employeeContactNumber) {
        this.employeeContactNumber = employeeContactNumber;
    }

    public String getEmployeeEmailId() {
        return employeeEmailId;
    }

    public void setEmployeeEmailId(String employeeEmailId) {
        this.employeeEmailId = employeeEmailId;
    }

    public String getVisitType() {
        return visitType;
    }

    public void setVisitType(String visitType) {
        this.visitType = visitType;
    }

    public String getCustomerSegment() {
        return customerSegment;
    }

    public void setCustomerSegment(String customerSegment) {
        this.customerSegment = customerSegment;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customerCategory='" + customerCategory + '\'' +
                ", customerName='" + customerName + '\'' +
                ", salutation=" + salutation +
                ", contactPersonName='" + contactPersonName + '\'' +
                ", lastName=" + lastName +
                ", contactNumber='" + contactNumber + '\'' +
                ", email='" + email + '\'' +
                ", employeeHclId='" + employeeHclId + '\'' +
                ", employeeKarvyId='" + employeeKarvyId + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", employeeEmail='" + employeeEmail + '\'' +
                ", description='" + description + '\'' +
                ", agreedNextSteps='" + agreedNextSteps + '\'' +
                ", followUpDate='" + followUpDate + '\'' +
                ", outcome='" + outcome + '\'' +
                ", userAccompanied='" + userAccompanied + '\'' +
                ", pursuedAcvInLakhs='" + pursuedAcvInLakhs + '\'' +
                ", signatureUrl='" + signatureUrl + '\'' +
                ", zone='" + zone + '\'' +
                ", region='" + region + '\'' +
                ", serviceEngagementType='" + serviceEngagementType + '\'' +
                ", meetingAgendaResult='" + meetingAgendaResult + '\'' +
                ", employeeContactNumber='" + employeeContactNumber + '\'' +
                ", employeeEmailId='" + employeeEmailId + '\'' +
                ", visitType='" + visitType + '\'' +
                ", customerSegment='" + customerSegment + '\'' +
                '}';
    }
}
