/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egyptionPyramid;

/**
 *
 * @author MA
 */
public class Pyramid {
  
    String pharaoh;
    String modern_name;
    String site;
    double height;

    public Pyramid(String pharoah, String modern_name, String site, double height) {
        this.pharaoh = pharoah;
        this.modern_name = modern_name;
        this.site = site;
        this.height = height;
    }

    public String getPharoah() {
        return pharaoh;
    }

    public String getModern_name() {
        return modern_name;
    }

    public String getSite() {
        return site;
    }

    public double getHeight() {
        return height;
    }

    public void setPharoah(String pharoah) {
        this.pharaoh = pharoah;
    }

    public void setModern_name(String modern_name) {
        this.modern_name = modern_name;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Pyramid{" + "pharaoh=" + pharaoh + ", modern_name=" + modern_name + ", site=" + site + ", height=" + height + '}';
    }
    
    
}


