package Interfaces;
import java.sql.SQLException;

public interface InterfaceEtudiantRepository{
    public void add(InterfaceEtudiant E) throws SQLException;
    public boolean Exists(String email) throws SQLException;
    public boolean Exists(int mat) throws SQLException;
    public boolean StudentVerification(InterfaceEtudiant E) throws SQLException;

}