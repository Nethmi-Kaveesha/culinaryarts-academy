package lk.ijse.dao;

//import lk.ijse.dao.custom.impl.EnrollmentDetailDAOImpl;
import lk.ijse.dao.custom.impl.ProgramDAOImpl;
import lk.ijse.dao.custom.impl.StudentDAOImpl;
import lk.ijse.dao.custom.impl.UserDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;
    public DAOFactory(){

    }
    public static DAOFactory getDaoFactory(){
        return daoFactory == null ? daoFactory = new DAOFactory() : daoFactory;
    }
    public enum DAOTypes{
       STUDENT , PROGRAM, USER,ENROLLMENT,ENROLLMENTDETAILS
    }
    public SuperDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case STUDENT:
                return new StudentDAOImpl();
            case PROGRAM:
                return new ProgramDAOImpl();
            case USER:
                return new UserDAOImpl();
            default:
                return null;
        }
    }
}