/* not completely sure if this file is needed
     * Set Spring configuration to serve the static resources of our React app
    @EnableWebMvc
    @Configuration
	public class MvcConfig extends WebMvcConfigurerAdapter {
	 
	    @Override
	    public void addResourceHandlers(
	      ResourceHandlerRegistry registry) {
	 
            registry.addResourceHandler("/static/**")
            
	          .addResourceLocations("/src/main/web-app/build/static/");
	        registry.addResourceHandler("/*.js")
	          .addResourceLocations("/src/main/web-app/build/");
	        registry.addResourceHandler("/*.json")
	          .addResourceLocations("/src/main/web-app/build/");
	        registry.addResourceHandler("/*.ico")
	          .addResourceLocations("/src/main/web-app/build/");
	        registry.addResourceHandler("/index.html")
	          .addResourceLocations("/src/main/web-app/build/index.html");
        }
        
	}	
*/	