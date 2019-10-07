<template>
  <v-container fluid fill-height>
    <v-layout align-center justify-center v-if="drawer">
      <v-flex xs12 sm8 md4>
        <v-card class="elevation-12">
          <v-toolbar color="primary" dark>
            <v-toolbar-title>Login form</v-toolbar-title>
          </v-toolbar>
          <v-card-text>
            <v-form>
              <v-text-field
                label="Login"
                name="login"
                v-model="userAddInfo.username"
                prepend-icon="mdi-account-circle"
                type="text"
              ></v-text-field>
              <v-text-field
                id="password"
                label="Password"
                name="password"
                v-model="userAddInfo.password"
                prepend-icon="mdi-lock-open"
                type="password"
                @keyup.enter="checkLogin"
              ></v-text-field>
            </v-form>
          </v-card-text>
          <v-card-actions>
            <!-- <v-spacer></v-spacer> -->
            <v-btn color="primary" @click="checkLogin" block>Login</v-btn>
          </v-card-actions>
          <v-card-actions>
            <v-btn color="yellow accent-4" block @click="drawer=!drawer">회원가입 또는 OAuth</v-btn>
          </v-card-actions>
        </v-card>
      </v-flex>
    </v-layout>
    <v-layout v-else align-center justify-center>
      <v-flex xs12 sm8 md4>
        <v-card class="elevation-12">
          <v-toolbar color="primary" dark flat>
            <v-toolbar-title>SignUp form</v-toolbar-title>
          </v-toolbar>
          <v-card-text>
            <v-form>
              <v-text-field
                label="UserName"
                v-model="userAddInfo.username"
                name="username"
                prepend-icon="mdi-account-circle"
                type="text"
              ></v-text-field>
              <v-text-field
                id="password"
                label="Password"
                v-model="userAddInfo.password"
                name="password"
                prepend-icon="mdi-lock-open"
                type="password"
              ></v-text-field>
              <v-text-field
                id="password"
                v-model="userAddInfo.passwordSec"
                label="Password 2차"
                name="password2"
                prepend-icon="mdi-lock-open-outline"
                type="password"
              ></v-text-field>

              <!-- 바인딩 시작-->
              <v-menu
                ref="menu"
                :close-on-content-click="false"
                v-model="menu"
                :nudge-right="40"
                transition="scale-transition"
                offset-y
                min-width="290px"
                max-width="290px"
              >
                <template v-slot:activator="{ on }">
                  <v-text-field
                    v-model="userAddInfo.dates"
                    label="Picker in menu"
                    name="createDate"
                    prepend-icon="mdi-calendar-check"
                    readonly
                    v-on="on"
                  ></v-text-field>
                </template>
                <v-date-picker v-model="userAddInfo.dates" no-title @input="menu = false"></v-date-picker>
              </v-menu>
              <!-- 바인딩 종료-->
            </v-form>
          </v-card-text>
          <v-card-actions>
            <!-- <v-spacer></v-spacer> -->
            <v-btn color="primary" block v-on:click="assignBtn">Assign</v-btn>
          </v-card-actions>
          <v-card-actions>
            <v-btn color="yellow accent-4" block @click="drawer=!drawer">돌아가기</v-btn>
          </v-card-actions>
        </v-card>
      </v-flex>
    </v-layout>
  </v-container>
  <!--
  <v-content>
     강의보고 수정
    <v-container class="fill-height" fluid style="max-width:700px;">
      <v-flex xs12 class="text-center">
        <v-card>Login Page</v-card>
      </v-flex>
    </v-container>
  </v-content>
  -->
</template>

<script>
// import { log } from 'util';
import axios from "axios";

export default {
  data: () => ({
    drawer: true,
    date: null,
    menu: false,
    modal: false,
    userAddInfo: {
      username: "",
      password: "",
      dates: ""
    }
  }),
  methods: {
    assignBtn: function() {
      if (this.userAddInfo.password === this.userAddInfo.passwordSec) {
        console.log("login axios");
        console.log("THIS", this.userAddInfo);
        let postdata = new URLSearchParams();
        postdata.append("username", this.userAddInfo.username);
        postdata.append("password", this.userAddInfo.password);
        postdata.append("dates", this.userAddInfo.dates);

        axios
          .post("/addUser", postdata)
          .then(res => {
            alert(res.data.comment);
            res.data.status == "200"
              ? (this.drawer = !this.drawer)
              : (this.userAddInfo.username = "");
            console.log(res);
          })
          .catch(err => {
            console.log("ERR", err);
          });
      } else {
        this.$store.commit('popup', { msg: '1차 비밀번호와 2차 비밀번호가 다릅니다', color: 'warning' })
      }
    },
    checkLogin: function() {
      let postdata = new URLSearchParams();
      postdata.append("username", this.userAddInfo.username);
      postdata.append("password", this.userAddInfo.password);
      axios.post("/checkUser",postdata)
      .then(res=>{
        console.log(res);
        res.data.status == 200
         ? this.$store.commit('updateUserInfo',res)
         : this.$store.state.isLogin=false;
        
        if(this.$store.state.loginPermission == 1){
          
        }
      }).catch(err=>{
        console.log(err);
      })
    },
  }
};
</script>

<style>
</style>