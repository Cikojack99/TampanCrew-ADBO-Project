/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Chip.Component;

/**
 *
 * @author TampanCrew arts
 * @version 0.03 ALPHA
 */
public class Maps {
    private String type;
    private String typeKind;
    
    public Maps(String type){
        this.type=type;
    }
    
    public Maps(String type,String TypeKind)
    {
        this(type);
        this.typeKind=typeKind;
    }
    
    public String getType()
    {
        return type;
    }
    
    public String getTypeKind()
    {
        return typeKind;
    }
}
