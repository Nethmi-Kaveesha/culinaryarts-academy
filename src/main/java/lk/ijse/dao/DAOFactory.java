package lk.ijse.dao;

import lk.ijse.dao.custom.impl.EnrollmentDetailDAOImpl;
import lk.ijse.dao.custom.impl.ProgramDAOImpl;
import lk.ijse.dao.custom.impl.StudentDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;
    public DAOFactory(){

    }
    public static DAOFactory getDaoFactory(){
        return daoFactory == null ? daoFactory = new DAOFactory() : daoFactory;
    }
    public enum DAOTypes{
       STUDENT , PROGRAM, ENROLLMENT,ENROLLMENTDETAILS
    }
    public SuperDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case STUDENT:
                return new StudentDAOImpl();
            case PROGRAM:
                return new ProgramDAOImpl();
            case ENROLLMENT:
                return new EnrollmentDetailDAOImpl();
            case ENROLLMENTDETAILS:
                return new EnrollmentDetailDAOImpl();
            default:
                return null;
        }
    }
}