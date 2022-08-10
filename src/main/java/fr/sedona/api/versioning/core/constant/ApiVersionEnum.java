package fr.sedona.api.versioning.core.constant;

public enum ApiVersionEnum {
    V1("v1"), V2("v2");

    private String version;

    ApiVersionEnum(String version) {
        this.version = version;
    }

    public String getVersion() {
        return this.version;
    }

    public static ApiVersionEnum getEnum(String version) {
        if (version != null) {
            for (ApiVersionEnum e : ApiVersionEnum.values()) {
                if (e.version.equals(version.toLowerCase())) {
                    return e;
                }
            }
        }
        return V1;// not found
    }
}