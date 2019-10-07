import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    isLogin:false,
    loginPermission: 2,
    userId: "",
    userNo: -1,
    userStore:{},
    sb: {
      act: false,
      msg: '',
      color: 'error'
    }
  },
  mutations: {
    updatePermission: function(state, userData) {
      state.loginPermission = userData.permission;
      state.userId = userData.userId;
      state.userNo = userData.userNo;
    },
    deletePermission: function(state) {
      state.loginPermission=2;
      state.userId="";
      state.userNo=-1;
      state.isLogin=false;
    },
    updateUserInfo:(state,payload)=>{
      // console.log("값 확인",payload);
      if(payload.data.status == 200){
        state.isLogin=true;
        let row = payload.data.datas;
        console.log("ROW :",row);
        state.userNo =row.userNO;
        state.userId=row.username;
        state.loginPermission=row.auth;
        console.log("STATE :",state);
        
        // this.updatePermission(state,row);

        //수정해야 할 부분
        if(row.auth == 2){
          // location.href="/"
          // console.log("STATE : ",state);
        }else{
          // location.href="/admin"
          // console.log("STATE : ",state);
        }
      }
    },
    popup (state, d) {
      state.sb.msg = d.msg
      state.sb.color = d.color
      state.sb.act = false
      if (d.act === undefined) state.sb.act = true
    }
  },
  actions: {},
  getters: {
    userIsAdmin:state=>{
      return state.isLogin
    },
    userSetting:state=>{
      return state.loginPermission;
    }
  }
});
