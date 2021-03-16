package org.geektimes.MyJmx;

import java.util.Date;

public class MyXiaoManager implements  MyXiaoManagerMBean {
    private  final MyXiao myXiao;


    public MyXiaoManager(MyXiao myXiao) {
        this.myXiao = myXiao;
    }

    @Override
    public Long getId() {
        return myXiao.getId();
    }

    @Override
    public void setId(Long id) {
        myXiao.setId(id);
    }

    @Override
    public String getName() {
        return myXiao.getName();
    }

    @Override
    public void setName(String name) {
        myXiao.setName(name);
    }

    @Override
    public Double getAge() {
        return myXiao.getAge();
    }

    @Override
    public void setAge(Double age) {
        myXiao.setAge(age);
    }

    @Override
    public Date getTime() {
        return myXiao.getTime();
    }

    @Override
    public void setTime(Date time) {
        myXiao.setTime(time);
    }
    public  MyXiao getMyXiao(){
        return myXiao;
    }
}
