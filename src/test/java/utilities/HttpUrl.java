package utilities;

public enum HttpUrl {
	
	POST("/v2/pet"),
	GET("/v2/pet/{id}"),
	PUT("/v2/pet/{id}"),
	DELETE("/v2/pet/{id}");
	
	private String url;
	
	private HttpUrl(String url) {
		this.url=url;
	}
	public String geturl() {
		return url;
	}
	
	public String geturl(int id) {
		return url.replace("{id}", String.valueOf(id));
	}

}
