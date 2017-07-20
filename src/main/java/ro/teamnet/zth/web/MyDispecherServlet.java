package ro.teamnet.zth.web;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.appl.controller.DepartmentController;
import ro.teamnet.zth.appl.controller.EmployeeController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by Tiberiu.Danciu on 7/20/2017.
 */

public class MyDispecherServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        dispatchReply(req, resp, "GET");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        dispatchReply(req, resp, "POST");
    }

    private void sendExceptionError(){}

    private Object dispatch(HttpServletRequest req){
        EmployeeController employeeController = new EmployeeController();
        DepartmentController departmentController = new DepartmentController();
        String response = "";

        if (req.getRequestURI().contains("/employees")){
            if (req.getRequestURI().contains("/one")){
                response = employeeController.getOneEmployee();
            }else {
                response = employeeController.getAllEmployees();
            }
        }
        if (req.getRequestURI().contains("/departments")){
            if (req.getRequestURI().contains("/all")) {
                response = departmentController.getAllDepartments();
            }else {
                response = departmentController.getAllDepartments();
            }
        }
        return response;
    }

    private void reply(HttpServletResponse resp,Object resultToDisplay){
        try {
            resp.getWriter().write(String.valueOf(resultToDisplay));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void dispatchReply(HttpServletRequest req, HttpServletResponse resp, String type){
            try {
                Object resultToDisplay = dispatch(req);
                reply(resp, resultToDisplay);
            } catch (Exception e){
                sendExceptionError();
            }
    }
}
