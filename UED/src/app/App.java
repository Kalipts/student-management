package app;

import controller.Controller;
import model.DBConnection;
import view.View;

/**
 * Created by kalipts on 04/12/2017.
 */

/*TODO: create database with mysql
    create database ued;
    use ued;
    create table students
    (
        scode varchar(7),
        sname varchar(45),
        class varchar(7),
        address varchar(45)
    )
*/

public class App {
    public static void main(String[] args) {
        View view = new View();
        DBConnection model = new DBConnection();
        new Controller(view, model);
    }
}
//todo: copyright © phan tran thanh nha 16cntt1