<template>
  <v-container fill-height fluid>
    <v-row justify="center">
      <v-col cols="12" md="8">
        <!-- <material-card color="green" title="Edit Profile" text="Complete your profile"> -->
          <v-form>
            <v-container class="py-0">
              <v-row>
                <v-col cols="12" md="4">
                  <v-text-field label="" disabled>
                    {{this.$store.userId}}
                  </v-text-field>
                </v-col>

                <v-col cols="12" md="4">
                  <v-text-field class="purple-input" label="User Name" />
                </v-col>
                <v-col cols="12">
                  <v-text-field label="주소" class="purple-input" />
                </v-col>
                <v-col cols="12" md="4">
                  <v-text-field label="번호" class="purple-input" />
                </v-col>
                <v-col cols="12" md="4">
                  <v-text-field label="생년월일" class="purple-input" />
                </v-col>
                <v-col cols="12" md="4">
                  <v-text-field class="purple-input" label="Point" type="number" disabled/>
                </v-col>

                <v-col cols="12">
                  <v-textarea
                    class="purple-input"
                    label="About Me"
                    value="국가는 농지에 관하여 경자유전의 원칙이 달성될 수 있도록 노력하여야 하며, 농지의 소작제도는 금지된다. 공무원의 신분과 정치적 중립성은 법률이 정하는 바에 의하여 보장된다."
                  />
                </v-col>

                <v-col cols="12" class="text-right">
                  <v-btn color="success">Update Profile</v-btn>
                </v-col>
                <v-col cols="12" class="text-center">
                  <v-row>예약 현황 등등
                    <v-col cols="12" v-for="item in userReserve" :key="item.no">
                      <v-card  elevation="20">
                        <v-row>
                        <v-col cols="12" md="6">
                        <v-card-title>{{item.roomName}} - {{item.roominfo}}</v-card-title>
                        <v-card-text>예약 신청일: {{item.createDate}}</v-card-text>
                        <v-card-text>예약 시작일: {{item.reservateDate}}</v-card-text>
                        <v-card-text>예약 종료일: {{item.reservateEndDate}}</v-card-text>
                        <v-card-text>상담내용: {{item.comment}}</v-card-text>
                        <v-card-text>숙박 인원 수: {{item.peopleNumb}}</v-card-text>
                        <v-card-text>숙박 인원 수: {{item.roomNo}}</v-card-text>
                        </v-col>
                        <v-col cols="12" md="6">
                          <v-img position="center center"  :src="item.imgSrc" aspect-ratio="1.1"></v-img>
                        </v-col>
                        </v-row>
                      </v-card>
                      <hr>
                    </v-col>
                  </v-row>
                </v-col>
              </v-row>
            </v-container>
          </v-form>
        <!-- </material-card> -->
      </v-col>
      <v-col cols="12" md="4">
        <v-card class="v-card-profile">
          <v-avatar slot="offset" class="mx-auto d-block elevation-6" size="130">
            <img src="https://source.unsplash.com/150x150/?round,flower" />
          </v-avatar>
          <v-card-text class="text-center">
            <h6 class="overline mb-3">유저</h6>

            <h4 class="font-weight-light">Harin Jeong</h4>

            <p class="font-weight-light">Test One Two Three</p>

            <v-btn color="success">Follow</v-btn>
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import axios from 'axios';
export default {
  // name:"userInfo"
  data:function(){
    return{
      userReserve:[],
    }
  },
  methods:{
    getReservationList:function(){
      let postdata=new URLSearchParams();
      postdata.append("userNo",this.$store.state.userNo);
      axios.post("/getUserReservation",postdata).then(res=>{
        res.data.forEach(element => {
          let tmp = new Date(element.createDate);
          element.createDate=`${tmp.getFullYear()}-${tmp.getMonth()+1}-${tmp.getDate()}`;
          tmp = new Date(element.reservateDate);
          element.reservateDate=`${tmp.getFullYear()}-${tmp.getMonth()+1}-${tmp.getDate()}`;
          tmp = new Date(element.reservateEndDate);
          element.reservateEndDate=`${tmp.getFullYear()}-${tmp.getMonth()+1}-${tmp.getDate()}`;
        });
        this.userReserve=res.data;
        console.log(res);
      }).catch(err=>{
        console.log(err);
      })
      console.log("11221");
    }
  },
  mounted:function(){
    // 사용자가 로그인 했는지 확인하기
    this.getReservationList();
  }
};
</script>

<style>
</style>