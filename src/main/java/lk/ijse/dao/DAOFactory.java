package lk.ijse.dao;


import lk.ijse.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;
    public DAOFactory(){

    }
    public static DAOFactory getDaoFactory(){
        return daoFactory == null ? daoFactory = new DAOFactory() : daoFactory;
    }
    public enum DAOTypes{
       STUDENT , PROGRAM, USER,ENROLLMENT,Enrollment_Details
    }
    public SuperDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case STUDENT:
                return new StudentDAOImpl();
            case PROGRAM:
                return new ProgramDAOImpl();
            case USER:
                return new UserDAOImpl();
            case ENROLLMENT:
                return new EnrollmentDAOImpl();
            case Enrollment_Details:
                return new EnrollmentDetailDAOImpl();
            default:
                return null;
        }
    }
}