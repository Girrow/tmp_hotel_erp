<template>
  <v-container fluid>
    <v-container fluid fill-height class="home-hero" style="max-height: 100vh;">
      <v-layout justify-center align-center column pa-5>
        <div class="display-4 font-weight-black white--text text-xs-center">GOODEE HOTEL</div>
        <div class="display-4 font-weight-black white--text text-xs-center mb-3"></div>
        <div
          class="display-1 font-weight-bold white--text text-xs-center"
        >Finally be founded in Vue + Spring MVC Pattern</div>
        <v-btn fab class="mt-5 brown darken-4">
          <v-icon large color="white">mdi-hotel</v-icon>
        </v-btn>
      </v-layout>
    </v-container>
    <v-row>
      
      <v-col cols="12">
        <v-row justify="center" class="green lighten-4">
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
                  label="Check In"
                  name="createDate"
                  prepend-icon="mdi-calendar-check"
                  readonly
                  v-on="on"
                ></v-text-field>
              </template>
              <v-date-picker v-model="datepickers.dates" no-title @input="menu = false"></v-date-picker>
            </v-menu>
          </v-col>
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
              <v-date-picker v-model="datepickers.dates" no-title @input="menu = false"></v-date-picker>
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
            <v-select v-model="reserveDate" :items="reserveDatas" label="인원 수"></v-select>
          </v-col>
          
          <v-col cols="12" md="2">
            <v-btn block color="lime" class="mt-4">조회</v-btn>
          </v-col>
          
        </v-row>
      </v-col>
    </v-row>

    <v-row style="max-width:1500px;margin:0 auto;min-height:500px;">
      <v-col cols="12">
        <v-row :align="alignment" :justify="justify">
          <v-col v-for="n in 3" :key="n" cols="12" md="4">
            <v-card class="pa-4 text-center" outlined tile>
              Comment {{n}}
              <br />쉿~🤐 공사중
              <v-img src="https://source.unsplash.com/1280x960/?hotel,nature" contain></v-img>
            </v-card>
          </v-col>
        </v-row>
      </v-col>
    </v-row>
    <!-- 
    <v-row style="width:1520px;margin:0 auto;">
      <v-col cols="12" justify="center">
        <v-row :align="alignment" :justify="justify" class="grey lighten-5 mt-10">
          <v-col  v-for="n in 3" :key="n" :cols="4">
            <v-card class="pa-4" outlined tile :elevation="elevation">
              Column {{n}}
              <v-img
                height="100%"
                src="https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Ft1.daumcdn.net%2Fcfile%2Ftistory%2F2206AA4A53A1126723"
                contain
              ></v-img>
            </v-card>
          </v-col>
        </v-row>
      </v-col>
      <v-col cols="12">
        <v-row justify="center">
          <v-col cols="6" md="2">
            <v-select v-model="alignment" :items="alignmentsAvailable" label="Align"></v-select>
          </v-col>

          <v-col cols="6" md="2">
            <v-select v-model="justify" :items="justifyAvailable" label="Justify"></v-select>
          </v-col>
        </v-row>
      </v-col>

    </v-row>
    -->
    <v-row style="max-width:1480px;margin:0 auto;min-height:500px;">
      <v-col cols="12">
        <v-row class="amber lighten-4" style="min-height:200px;">
          <v-col cols="12" md="6">
            <v-card class="pa-3 text-center" outlined tile style="max-height:400px;width:100%;">
              <v-btn class="mb-3">Event 특가기획</v-btn>
              <v-container fluid fill-height class="home-event">
                <v-layout justify-center align-center column pa-5>
                  <div class="display-4 font-weight-black white--text text-xs-center">
                    <br />
                  </div>
                  <div class="display-4 font-weight-black white--text text-xs-center mb-3">
                    <br />
                  </div>
                  <div class="display-1 font-weight-bold white--text text-xs-center">
                    <br />
                  </div>
                </v-layout>
              </v-container>
            </v-card>
          </v-col>
          <v-col cols="12" md="6">
            <v-card class="pa-3 text-center" outlined tile style="max-height:400px;width:100%;">
              <v-btn class="mb-3">Promotion 상품 추천</v-btn>
              <v-container fluid fill-height class="home-promotion">
                <v-layout justify-center align-center column pa-5>
                  <div class="display-4 font-weight-black white--text text-xs-center">
                    <br />
                  </div>
                  <div class="display-4 font-weight-black white--text text-xs-center mb-3">
                    <br />
                  </div>
                  <div class="display-1 font-weight-bold white--text text-xs-center">
                    <br />
                  </div>
                </v-layout>
              </v-container>
            </v-card>
          </v-col>
        </v-row>
      </v-col>
    </v-row>

    <v-row>
      <v-img
        src="https://previews.123rf.com/images/kolesik/kolesik1604/kolesik160400035/55848163-%EB%B9%88%ED%8B%B0%EC%A7%80-%EC%B4%88%EB%8C%80%EC%9E%A5-%EC%84%B8%EB%A0%A8%EB%90%9C-%EC%B9%B4%EB%93%9C-%EB%B3%B5%EA%B3%A0%ED%92%8D-%EC%9E%A5%EC%8B%9D-%EA%B3%A0%EA%B8%89%EC%8A%A4%EB%9F%B0-%EB%94%94%EC%9E%90%EC%9D%B8.jpg"
        style="height:200px;"
      ></v-img>
    </v-row>

    <v-row style="max-width:1500px;margin:0 auto;min-height:500px;">
      <v-col cols="12" md="6">
        <v-img
          src="https://www.shillastay.com/images/contents/dining/CAFE/R00000009IAZ_KR.jpg"
          contain
        ></v-img>
      </v-col>
      <v-col cols="12" md="6">
        <v-container fluid fill-height style="max-height: 100vh;">
          <v-layout justify-center align-center column pa-5>
            <div class="display-2 font-weight-black text-xs-center fontme">Modern & Delightful, Cafe</div>
            <div class="display-1 fontme">
              세련된 분위기 속 엄선된 메뉴
              <br />신선한 음식을 맛볼 수 있습니다.
            </div>
          </v-layout>
        </v-container>
      </v-col>
      <v-col cols="12" md="6">
        <v-container fluid fill-height style="max-height: 100vh;">
          <v-layout justify-center align-center column pa-5>
            <div class="display-4 font-weight-black text-xs-center fontme">
              마!
              <br />이게 감성이다
            </div>
            <div class="display-4 font-weight-black text-xs-center mb-3"></div>
            <div class="display-1 font-weight-bold text-xs-center fontme">예약하러 가기</div>
            <v-btn fab class="mt-5 brown darken-4">
              <v-icon large color="white">mdi-hotel</v-icon>
            </v-btn>
          </v-layout>
        </v-container>
      </v-col>
      <v-col cols="12" md="6">
        <line-height></line-height>
      </v-col>
    </v-row>

    <v-card height="100px">
      <v-footer>
        <v-card flat tile width="100%" class="brown lighten-2 text-center">
          <v-card-text>
            <v-btn v-for="icon in icons" :key="icon" class="mx-4" icon>
              <v-icon size="24px">{{ icon }}</v-icon>
            </v-btn>
          </v-card-text>

          <v-divider></v-divider>

          <v-card-text class="white--text">
            {{ new Date().getFullYear() }} —
            <strong>Vuetify</strong>
          </v-card-text>
        </v-card>
      </v-footer>
    </v-card>
  </v-container>
</template>

<script>
import { Line } from "vue-chartjs";

let aa = {
  extends: Line,
  mounted() {
    this.renderChart(
      {
        labels: ["-6", "-5", "-4", "-3", "-2", "-1", "0"],
        datasets: [
          {
            label: "현재 예약률",
            backgroundColor: "#FFFF8D",
            data: [44, 55, 66, 75, 88, 89, 95]
          }
        ]
      },
      { responsive: true, maintainAspectRatio: false }
    );
  }
};

export default {
  data() {
    return {
      reserveDate: "",
      reserveDatas: ["1", "2", "3", "4", "5"],
      alignmentsAvailable: ["start", "center", "end", "baseline", "stretch"],
      alignment: "center",
      dense: false,
      justifyAvailable: [
        "start",
        "center",
        "end",
        "space-around",
        "space-between"
      ],
      justify: "space-between",
      icons: ["mdi-home", "mdi-email", "mdi-calendar", "mdi-delete"],
      menu: false,
      datepickers: {}
    };
  },
  components: {
    "line-height": aa
  }
};
</script>

<style scoped>
.home-hero {
  background: url("http://source.unsplash.com/0BhSKStVtdM");
  background-size: cover;
  width: 100%;
  height: 100%;
}
.home-event {
  background: url("../../assets/event.jpg");
  /* background-image: "http://www.shillastay.com/images/contents/main/MAIN_GHMSS/R0000000VX1N_KR.jpg"; */
  background-size: cover;
  width: 100%;
  height: 100%;
}
.home-promotion {
  background: url("http://www.shillastay.com/images/contents/main/MAIN_GHMSS/R0000000VWND_KR.jpg");
  background-size: cover;
  width: 100%;
  height: 100%;
}
.fontme {
  font-family: "Nanum Pen Script", cursive !important;
}
</style>