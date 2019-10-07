<template>
  <v-app id="inspire">
    <v-navigation-drawer v-if="drawerU" app clipped permanent>
      <v-list dense>
        <v-list-item router :to="{name:'userHome'}" exact>
          <v-list-item-action>
            <v-icon>mdi-home</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title class="fontme">Home</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <v-list-item router :to="{name:'userReservation'}" exact>
          <v-list-item-action>
            <v-icon>mdi-calendar-text-outline</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title class="fontme">예약</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <v-list-item router :to="{name:'userBoard'}" exact>
          <v-list-item-action>
            <v-icon>mdi-message-reply-text</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title class="fontme">게시판</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <v-list-item router :to="{name:'userInfo'}" exact>
          <v-list-item-action>
            <v-icon>mdi-bookmark-multiple</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title class="fontme">개인 정보</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <v-list-item router :to="{name:'hotelInfo'}" exact>
          <v-list-item-action>
            <v-icon>mdi-hotel</v-icon>
          </v-list-item-action> 
          <v-list-item-content>
            <v-list-item-title class="fontme">호텔 정보</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>

    <v-navigation-drawer v-if="drawer" app clipped permanent>
      <v-list dense>
        <v-list-item router :to="{name:'adminHome2'}" exact>
          <v-list-item-action>
            <v-icon large color="green darken-2">mdi-domain</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>관리통계</v-list-item-title>
          </v-list-item-content>
        </v-list-item>

        <v-list-item router :to="{name:'adminSetting'}" exact>
          <v-list-item-action>
            <v-icon large color="red darken-2">mdi-settings</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>이벤트 세팅</v-list-item-title>
          </v-list-item-content>
        </v-list-item>

        <v-list-item router :to="{name:'adminPrice'}" exact>
          <v-list-item-action>
            <v-icon large color="orange darken-2">mdi-camcorder</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>가격 조정</v-list-item-title>
          </v-list-item-content>
        </v-list-item>

        <v-list-item router :to="{name:'adminNow'}" exact>
          <v-list-item-action>
            <v-icon large color="yellow darken-2">mdi-magnify</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>회원 관리</v-list-item-title>
          </v-list-item-content>
        </v-list-item>

        <v-list-item router :to="{name:'adminContact'}" exact>
          <v-list-item-action>
            <v-icon large color="blue darken-2">mdi-message-text</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>상담내역</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>
    <!---------------------------------------------Navigation End-->

    <!-- 사용자 -->
    <!---------------------------------------------Navigation2 Hei End-->
    <v-app-bar :height="100" v-if="userSetting == 2" app clipped-left color="lime lighten-4">
      <v-app-bar-nav-icon color="black" @click.stop="drawerU = !drawerU"></v-app-bar-nav-icon>
      <div class="flex-grow-1"></div>
      <!-- Main logo에 Router to 추가하기 차후 수정 // 완료 router :to="{name:'userHome'}" -->
      <router-link :to="{name:'userHome'}">
        <div style="width:130px;height:100px;" class="ml-12" router :to="{name:'userHome'}">
          <v-img id="logos" position="bottom bottom" src="@/assets/userlogo.png"></v-img>
        </div>
      </router-link>
      <div class="flex-grow-1"></div>

      <!-- 차후에 삭제할 버튼 -->
      <v-btn color="blue">
        <span v-if="userIsAdmin">ID : {{this.$store.state.userId}}</span>
        <span v-else>LOGIN Status: {{userIsAdmin}}</span>
      </v-btn>
      <v-btn v-if="!userIsAdmin" router :to="{name:'login'}">LOGIN</v-btn>
      <v-btn v-else router :to="{name:'userHome'}" @click="logoutT">LOGOUT</v-btn>
    </v-app-bar>

    <!-- 관리 -->
    <v-app-bar :height="100" v-else app clipped-left color="indigo darken-2" dark>
      <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
      <v-row align="center" justify="center">
        <div class="flex-grow-1"></div>
        <v-toolbar-title>HOTEL</v-toolbar-title>
        <v-toolbar-title>
          <v-img
            width="100"
            src="data:image/png;base64,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"
          ></v-img>
        </v-toolbar-title>
        <div class="flex-grow-1"></div>
        <v-btn @click="logoutT">LOGOUT</v-btn>
      </v-row>
    </v-app-bar>

    <v-content>
      <router-view />
      <!-- alert창-->
      <v-snackbar v-model="$store.state.sb.act" :color="$store.state.sb.color" class="fontme">
        {{ $store.state.sb.msg }}
        <v-btn text @click="$store.commit('popup', { act: false })">닫기</v-btn>
      </v-snackbar>
    </v-content>
    <v-footer app>
      <span>&copy; 2019 COPYRIGHT @기러우</span>
    </v-footer>
  </v-app>
</template>

<script>
import { mapGetters } from "vuex";
import axios from "axios";
/* eslint-disable */
export default {
  props: {
    source: String
  },
  data: () => ({
    drawer: false,
    drawerU: false,
    isAdmin:false,
  }),
  computed: {
    ...mapGetters(["userIsAdmin", "userSetting"])
  },
  watch:{
    userSetting:function(val){
      if(val == 1){
        this.drawerU=false;
        this.drawer=true;
      }else{
        console.log("나머지");
      }
      return true;
    }
  },
  created() {
    this.$vuetify.theme.dark = false;
  },
  methods: {
    firstTest: function() {
      console.log("!1");
    },
    logoutT: function() {
      //axios로 session 마감처리할것
      console.log("눌림");
      this.$store.commit("deletePermission");
      location.href = "/logout";
    },
    getUserSession: function() {
      axios
        .post("/getUserSession")
        .then(res => {
          this.$store.commit("updateUserInfo", res);
          if(this.userSetting == 1){
            this.drawer=true;
            this.drawerU=false;
          }
        })
        .catch(err => {
          console.log(err);
        });
    }
  },
  mounted: function() {
    this.getUserSession();
  }
  // 사용자의 값을 누를때마다 갱신하는것. router guard로 변경
  // updated:function(){
  //   this.getUserSession();
  // }
};
</script>

<style>
#inspire{
  font-family: 'Nanum Pen Script', cursive;
  font-size: 120%!important;
  font-weight: 600!important;
}
#logos {
  height: 100%;
}

.fontme{
  font-family: 'Nanum Pen Script', cursive;
  font-size: 120%!important;
}
</style>