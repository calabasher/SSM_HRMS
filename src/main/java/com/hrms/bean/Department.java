package com.hrms.bean;

/**
 * @author GenshenWang.nomico
 * @date 2018/3/5.
 */
public class Department {
    private Integer deptId;
    private String deptLeader;
    private String deptName;

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptLeader() {
        return deptLeader;
    }

    public void setDeptLeader(String deptLeader) {
        this.deptLeader = deptLeader;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    //  无参构造方法， 当类中没有定义构造函数时，系统会指定给该类加上一个空参数的构造函数。这个是类中默认的构造函数。当类中如果自定义了构造函数，这时默认的构造函数就没有了
    public Department() {
    }
    //  全参构造方法
    public Department(Integer deptId, String deptLeader, String deptName) {
        this.deptId = deptId;
        this.deptLeader = deptLeader;
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptId=" + deptId +
                ", deptLeader='" + deptLeader + '\'' +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
