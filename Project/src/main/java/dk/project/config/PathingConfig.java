// Package
package dk.project.config;

public class PathingConfig {

    // Attributes
    private boolean isDeployment = false;

    // ___________________________________________________________
    // To prevent multi branches for deployment / local

    public String setPathing(){

        if(!this.isDeployment){
            return "src/main/resources/static/";
        }

        return "content/";

    }

    // ___________________________________________________________

    public void setDeployment(boolean isDeployment){
        this.isDeployment = isDeployment;
    }

    // ___________________________________________________________

    public boolean getDeployment(){
        return this.isDeployment;
    }

}