public enum StatusResponse {

    SUCCESS("Success"),
    ERROR("Error");

    private String status;

    private StatusResponse(String status){
        this.status = status;

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        status = status;
    }
}
