package com.job.jobPro.member.vo;

import java.sql.Date;

//member테이블관련 데이터를 보관, 제공하는 클래스
public class MemberVO {
   private String id;
   private String password;
   private String name;
   private String gender;
   private String email;
   private String phone;
   private String address;
   private String birth;
   private Date regdate;
   private String u_delete;
   private Date deldate;
   private String adminok;
   private String djob;
   private String grade;

   
   
   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getGender() {
      return gender;
   }

   public void setGender(String gender) {
      this.gender = gender;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public String getBirth() {
      return birth;
   }

   public void setBirth(String birth) {
      this.birth = birth;
   }

   public Date getRegdate() {
      return regdate;
   }

   public void setRegdate(Date regdate) {
      this.regdate = regdate;
   }

   public String getU_delete() {
      return u_delete;
   }

   public void setU_delete(String u_delete) {
      this.u_delete = u_delete;
   }

   public Date getDeldate() {
      return deldate;
   }

   public void setDeldate(Date deldate) {
      this.deldate = deldate;
   }

   public String getAdminok() {
      return adminok;
   }

   public void setAdminok(String adminok) {
      this.adminok = adminok;
   }

   public String getDjob() {
      return djob;
   }

   public void setDjob(String djob) {
      this.djob = djob;
   }
   
   public String getgrade() {
      return grade;
   }

   public void setgrade(String grade) {
      this.grade = grade;
   }



   public MemberVO() {}

   public MemberVO(String id, String password, String name, String gender, String email,
               String phone, String address, String birth, Date regdate,
               String u_delete, Date deldate, String adminok, String djob,String grade) {
   super();
   this.id=id;
   this.password=password;
   this.name=name;
   this.gender=gender;
   this.email=email;
   this.phone=phone;
   this.address=address;
   this.regdate=regdate;
   this.u_delete=u_delete;
   this.deldate=deldate;
   this.adminok=adminok;
   this.djob=djob;
   this.birth=birth;
   this.grade=grade;
   }

   @Override
   public String toString() {
      return "MemberVO [id=" + id + ", password=" + password + ", name=" + name + ", gender=" + gender + ", email="
            + email + ", phone=" + phone + ", address=" + address + ", birth=" + birth + ", regdate=" + regdate
            + ", u_delete=" + u_delete + ", deldate=" + deldate + ", adminok=" + adminok + ", djob=" + djob
            + ", grade=" + grade + "]";
   }





   

}