package lk.ijse.bo;


import lk.ijse.bo.custom.impl.ProgramBOImpl;
//import lk.ijse.bo.custom.impl.RejistrationBOImpl;
import lk.ijse.bo.custom.impl.StudentBOImpl;
import lk.ijse.bo.custom.impl.UserBOImpl;

public class BOFactory {
    private static BOFactory boFactory;
    public BOFactory(){

    }
    public static BOFactory getBoFactory(){
        return boFactory == null ? boFactory = new BOFactory() : boFactory;
    }
    public enum BOTypes{
       STUDENT ,PROGRAM , USER, REJISTER
    }
    public SuperBO getBO(BOTypes boTypes){
        switch (boTypes){
            case STUDENT:
                return  new StudentBOImpl();
            case PROGRAM:
                return new ProgramBOImpl();
            case USER:
                return new UserBOImpl();
            default:
                return null;
        }
    }
}
