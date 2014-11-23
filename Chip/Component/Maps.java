/**
 * Class Maps ini berfungsi sebagai penyimpan kordinat di sebuah game field, agar memudahkan penggambaran dan
 * pengambilan koordinat di kelas engine.
 */

package Chip.Component;

/**
 *
 * @author TampanCrew arts (Harseto and Alvin)
 * @version 0.04 ALPHA
 */
public class Maps {
    /**
     * type adalah sebuah attribute String yang merepresentasikan tipe dari objek di suatu kordinat map, 
     * contoh: di koordinat Maps[1][1] adalah sebuah Item atau Obstacles.
     */
    private String type;
    /**
     * typeKind adalah sebuah attrbute String yang merepresentasikan jenis tipe dari objek di suatu kordinat 
     * map, contoh: di kordinat Maps[1][1] adalah sebuah Laser atau Brown Key, dll.
     */
    private String typeKind;
    
    /**
     * Constructor pertama ini untuk menginisialisasi sebuah Maps yang hanya berisi sebuah type tanpa ada typeKind,
     * biasanya untuk merepresentasikan suatu objek tanpa turunan.
     * @param type type adalah tipe dari objek di suatu kordinat map. More Information at type attribute javadocs.
     */
    
    
    /**
     * Constructor kedua ini untuk menginisialisasi sebuah Maps yang mempunyai type dan typeKind, biasanya 
     * untuk merepresentasikan suatu objek dengan turunan.
     * @param type type adalah tipe dari objek di suatu kordinat map. More Information at type attribute javadocs.
     * @param TypeKind typeKind adalah sebuah jenis tipe dari objek di suatu kordinat map. More Information at typeKind attribute javadocs.
     */
    public Maps(String type,String TypeKind)
    {
        this.type=type;
        this.typeKind = TypeKind;
    }
    
    /**
     * Mengambil attribute type untuk digunakan di kelas-kelas lain. More Information about type attribute in javadocs.
     * @return Attribute type.
     */
    public String getType()
    {
        return type;
    }
    
    /**
     * Mengambil attribute typeKind untuk digunakan di kelas-kelas lain. More Information at typeKind attribute in javadocs.
     * @return Attribute typeKind.
     */
    public String getTypeKind()
    {
        return typeKind;
    }
}
