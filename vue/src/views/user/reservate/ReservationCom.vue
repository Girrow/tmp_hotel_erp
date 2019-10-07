<template>
  <v-container fluid>
    <v-row>
      <v-col cols="12" class="text-center">
        <h1>RESERVATION Table</h1>
        <h3>{{roomInfo}}</h3>
      </v-col>
    </v-row>
    <v-row>
      <v-col cols="12">
        <v-card align="center" justify="center">
          <v-btn x-large color="orange lighten-3">{{roomInfo.roomName}} Room</v-btn>
          <v-img :src="roomInfo.firstI" max-width="1200"></v-img>
          <v-card-text>{{roomInfo.firstT}}</v-card-text>
          <v-card-text>{{roomInfo.firstT}}</v-card-text>
        </v-card>
      </v-col>
    </v-row>
    <v-row>
      <v-col cols="12">
        <v-row justify="center" class="orange lighten-4">
          <v-col cols="12" md="2">
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
                  v-model="datepickers.dates"
                  label="Check Out"
                  name="createDate"
                  prepend-icon="mdi-calendar-check"
                  readonly
                  v-on="on"
                ></v-text-field>
              </template>
              <v-date-picker
                v-model="datepickers.dates"
                :min="limitDate"
                no-title
                @input="menu = false"
              ></v-date-picker>
            </v-menu>
          </v-col>

          <v-col cols="12" md="2">
            <v-menu
              ref="menu2"
              :close-on-content-click="false"
              v-model="menu2"
              :nudge-right="40"
              transition="scale-transition"
              offset-y
              min-width="290px"
              max-width="290px"
            >
              <template v-slot:activator="{ on }">
                <v-text-field
                  v-model="datepickers.dates2"
                  label="Check Out"
                  name="createDate"
                  prepend-icon="mdi-calendar-check"
                  readonly
                  v-on="on"
                ></v-text-field>
              </template>
              <v-date-picker
                v-model="datepickers.dates2"
                :min="datepickers.dates"
                no-title
                @input="menu2 = false"
              ></v-date-picker>
            </v-menu>
          </v-col>

          <!--
          <v-col cols="12" md="2">
            <v-select v-model="reserveDate" :items="reserveDatas" label="체크 인"></v-select>
          </v-col>
          <v-col cols="12" md="2">
            <v-select v-model="reserveDate" :items="reserveDatas" label="체크 아웃"></v-select>
          </v-col>
          -->
          <v-col cols="12" md="2">
            <v-select v-model="datepickers.numb" :items="reserveDatas" label="인원 수"></v-select>
          </v-col>

          <v-col cols="12" md="2">
            <v-btn block color="lime lighten-3" class="mt-4" @click="getAvailableRoom">조회</v-btn>
          </v-col>
        </v-row>
      </v-col>
    </v-row>

    <v-col cols="12">
      <v-row>
        <v-col
          cols="12"
          sm="4"
          v-for="item in resultRooms"
          :key="item.no"
          @click="clickThisCard(item)"
          v-bind:class="[{ 'red' : item.clicked }]"
        >
          <v-card class="text-center">
            <!-- <v-btn v-if="item.clicked" class="text-center"
              router :to="{name:'reserveComf',params:{item:item}}"
            >선택됨 예약확정하기</v-btn>-->
            <v-btn v-if="item.clicked" class="text-center" @click="pushReservation(item)">선택됨 예약확정하기</v-btn>
            <v-card-title class="text-center">{{item.roomName}}-{{item.no}}호</v-card-title>
            {{item.roomInfo}}
            <br />
            {{item.price}}
            {{item.maxNumb}}
          </v-card>
        </v-col>
      </v-row>
    </v-col>

    <v-btn router :to="{name:'userReservation'}">돌아가기</v-btn>
  </v-container>
</template>

<script>
/* eslint-disable */
import axios from "axios";
export default {
  data: function() {
    return {
      roomInfo: this.$route.params.roomInfo,
      menu: false,
      menu2: false,
      datepickers: {},
      reserveDatas: ["1", "2", "3", "4", "5"],
      limitDate: "",
      resultRooms: []
    };
  },
  methods: {
    getAvailableRoom: function() {
      console.log("Get Data", this.datepickers);
      let postdata = new URLSearchParams();
      postdata.append("dates", this.datepickers.dates);
      postdata.append("dates2", this.datepickers.dates2);
      postdata.append("numb", this.datepickers.numb);
      postdata.append("roomType", this.roomInfo.no);
      // { headers: { 'Content-Type': 'application/json' } }
      axios
        .post("/getAvailableRoom", postdata)
        .then(res => {
          console.log(res);
          res.data.forEach(element => {
            element.clicked = false;
          });
          this.resultRooms = res.data;
        })
        .catch(err => {
          console.log(err);
        });
    },
    test: function() {
      let date = new Date();
      let year = date.getFullYear(); //yyyy
      let month = 1 + date.getMonth(); //M
      month = month >= 10 ? month : "0" + month; //month 두자리로 저장
      let day = date.getDate(); //d
      day = day >= 10 ? day : "0" + day; //day 두자리로 저장
      this.limitDate = year + "-" + month + "-" + day;
    },
    clickThisCard: function(item) {
      item.clicked = !item.clicked;
    },
    pushReservation: function(datas) {
      if (this.$store.state.userNo == -1) {
        this.$store.commit('popup', { msg: '로그인을 먼저 실행해주세요', color: 'warning' })
      } else {
        console.log("선택된 값 :", datas);
        let postdata = new URLSearchParams();
        postdata.append("dates", this.datepickers.dates);
        postdata.append("dates2", this.datepickers.dates2);
        postdata.append("numb", this.datepickers.numb);
        postdata.append("roomType", this.roomInfo.no);
        postdata.append("no", datas.no);
        postdata.append("user", this.$store.state.userNo);
        axios
          .post("/pushNewReservation", postdata)
          .then(res => {
            console.log(res);
          })
          .catch(err => {
            console.log(err);
          });
      }
    }
  },
  mounted: function() {
    this.test();
  }
};
</script>

<style>
</style>