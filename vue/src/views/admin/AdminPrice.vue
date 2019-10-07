<template>
  <v-container fluid class="grey lighten-5" style="max-width:1400px;">
    <v-row justify="center" no-gutters>
      <v-col cols="12" md="12" class="text-center">Price Setting</v-col>
    </v-row>

    <v-row justify="center" style="max-width:1400px;">
      <v-col cols="12" md="4" color="orange">
        <v-list nav rounded>
          <v-subheader>Partition Type</v-subheader>
          <v-list-item-group v-model="item" color="primary">
            <v-list-item v-for="(item, i) in items" :key="i" @click="changeSelectInfo(i+1)">
              <v-list-item-icon>
                <v-icon v-text="item.icon"></v-icon>
              </v-list-item-icon>
              <v-list-item-content>
                <v-list-item-title v-text="item.text"></v-list-item-title>
              </v-list-item-content>
            </v-list-item>
          </v-list-item-group>
        </v-list>
      </v-col>

      <v-col cols="12" md="8">
        <v-card justify="center">
          <v-card-title>Room No.</v-card-title>
          <v-divider class="mx-4"></v-divider>
        </v-card>
        <v-card v-for="roomItem in selectInfo" :key="roomItem.no" justify="center" dark>
          <v-btn block style="min-height:80px;" @click.native="roomItem.tf = !roomItem.tf">
            <v-card-title>{{roomItem.no}}</v-card-title>
            <v-card-actions>
              <v-icon>{{ roomItem.tf ? 'mdi-eject-outline' : 'mdi-chevron-triple-down' }}</v-icon>
            </v-card-actions>
          </v-btn>
          <!-- CARD 내부 SELECT -->
          <v-slide-y-transition>
            <v-card-text v-show="roomItem.tf" class="fontme">
              <v-row>
                <v-col cols="6" sm="6" align="center">
                  <v-toolbar flat color="pink" dark>
                    <!-- <v-icon>mdi-arrow-left</v-icon> -->
                    <v-toolbar-title>현재 가격</v-toolbar-title>
                    <div class="flex-grow-1"></div>
                    <v-toolbar-title class="headline">{{roomItem.dprice}}</v-toolbar-title>
                  </v-toolbar>
                </v-col>
                <v-col cols="6" sm="6" align="center">
                  <v-toolbar color="blue" dark>
                    <!-- <v-icon>mdi-arrow-left</v-icon> -->
                    <v-toolbar-title>수정할 가격</v-toolbar-title>
                    <div class="flex-grow-1"></div>
                    <v-text-field
                      class="pt-7 headline"
                      style="width:20px;"
                      :value="roomItem.dprice"
                      outlined
                      label="Price"
                    ></v-text-field>
                  </v-toolbar>
                </v-col>
              </v-row>
              <v-row>
                <v-col cols="12">
                  <v-toolbar color="green darken-1">
                    <v-toolbar-title>현재 예약 상태 :</v-toolbar-title>
                    <div class="flex-grow-1"></div>
                    <span v-if="roomItem.status=='F'">예약 Free</span>
                  <span v-else>예약되어 있음</span>
                  </v-toolbar>
                  <br>
                  <v-btn color="purple darken-1" class="mb-4" block>수정하기</v-btn>
                  <v-btn block @click="roomItem.tf = !roomItem.tf">취소하기</v-btn>
                </v-col>
              </v-row>
            </v-card-text>
          </v-slide-y-transition>
        </v-card>
      </v-col>
    </v-row>
    <v-row>하단 부 Footer 영역 따로 사용할 예정</v-row>
  </v-container>
</template>

<script>
import axios from "axios";

export default {
  data: function() {
    return {
      item: 1,
      items: [
        { text: "Standard", icon: "mdi-clock" },
        { text: "Business", icon: "mdi-account" },
        { text: "Suite", icon: "mdi-flag" },
        { text: "Suite", icon: "mdi-dots-vertical" },
        { text: "Super Duper", icon: "mdi-dots-vertical" },
        { text: "Kowa Delux", icon: "mdi-history" },
        { text: "Suite Tween", icon: "mdi-check-circle" },
        { text: "Suite Double", icon: "mdi-upload" },
        { text: "Delux Suite Tween", icon: "mdi-cloud-upload" }
      ],
      roomItems: [
        { no: 1, tf: false },
        { no: 2, tf: false },
        { no: 3, tf: false },
        { no: 4, tf: false },
        { no: 5, tf: false }
      ],
      roomInfo: [],
      selectInfo: []
    };
  },
  methods: {
    getAllRoomInfo: function() {
      axios
        .post("/getAllRoomInfo")
        .then(res => {
          console.log(res);
          res.data.forEach(element => {
            element.tf = false;
          });
          this.roomInfo = res.data;
        })
        .catch(err => {
          console.log(err);
        });
    },
    changeSelectInfo: function(index) {
      console.log(index);
      this.selectInfo = [];
      this.roomInfo.forEach(element => {
        if (element.roomType == index) {
          element.tf = false;
          this.selectInfo.push(element);
        }
      });
    }
  },
  mounted: function() {
    this.getAllRoomInfo();
  }
};
</script>

<style scoped>
.fontme {
  font-family: "Nanum Pen Script", cursive;
  font-size: 120% !important;
}
</style>
