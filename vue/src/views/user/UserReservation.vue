<template>
  <div>
    User Reservation
    <v-row>
      <!--
      <v-card max-width="344" class="mx-auto">
        <v-list-item>
          <v-list-item-avatar color="grey"></v-list-item-avatar>
          <v-list-item-content>
            <v-list-item-title class="headline">Standardss</v-list-item-title>
            <v-list-item-subtitle>1인 사용자를 위한 선택</v-list-item-subtitle>
          </v-list-item-content>
        </v-list-item>

        <v-img src="https://source.unsplash.com/344x195/?hotel" height="194"></v-img>


        <v-card-text>Standard One</v-card-text>

        <v-card-actions>
          <v-btn text color="lime" dark @click.stop="dialog = true">상세보기</v-btn>

          <v-dialog v-model="dialog" max-width="800" scrollable>
            <v-card style="min-height:500px;">
              <v-card-title class="headline">Standard Service</v-card-title>
              <hr />
              <v-card-text>
                채울내용
                <br />
              </v-card-text>
              <v-card-actions>
                <div class="flex-grow-1"></div>
                <v-btn color="green darken-1" text @click="dialog = false">예약하기</v-btn>
                <v-btn color="green darken-1" text @click="dialog = false">취소</v-btn>
                <div class="flex-grow-1"></div>
              </v-card-actions>
            </v-card>
          </v-dialog>
          <div class="flex-grow-1"></div>
          <v-btn icon>
            <v-icon>mdi-heart</v-icon>
          </v-btn>
          <v-btn icon>
            <v-icon>mdi-share-variant</v-icon>
          </v-btn>
        </v-card-actions>
      </v-card>
      -->
      <v-col v-for="(item,index) in rooms" :key="item.no" cols="4" md="4" sm="6">
        <v-card max-width="344" class="mx-auto">
          <v-list-item>
            <v-list-item-avatar color="pink lighten-4">{{index+1}}</v-list-item-avatar>
            <v-list-item-content>
              <v-list-item-title class="headline">{{item.roomName}}</v-list-item-title>
              <v-list-item-subtitle>{{item.price}}</v-list-item-subtitle>
            </v-list-item-content>
          </v-list-item>

          <v-img :src="item.firstI" :lazy-src="'https://ak1.picdn.net/shutterstock/videos/23800711/thumb/1.jpg'" height="194"></v-img>

          <v-card-text style="font-size:20px;">INDEX : {{index}}</v-card-text>

          <v-card-actions>
            <v-btn
              text
              color="lime"
              dark
              @click.stop="item.dialog = true"
              @click="getSeveralImg(index+1)"
            >상세보기</v-btn>
            <!-- Modal practice-->
            <v-dialog v-model="item.dialog" max-width="800" scrollable>
              <v-card >
                <v-card-title class="headline">{{item.roomName}} Service</v-card-title>
                <hr />
                <v-card-text>
                  <v-img :src="roomsImg[1]" :lazy-src="'https://picsum.photos/id/11/100/60'"></v-img>
                  {{item.firstT}}
                  <v-img
                    position="bottom bottom"
                    :src="item.firstI"
                    :lazy-src="'https://picsum.photos/id/11/100/60'"
                  ></v-img>
                  <br />
                  <!-- <v-img position="bottom bottom" src="@/assets/standard_2.jpg"></v-img> -->
                </v-card-text>
                <v-card-actions>
                  <div class="flex-grow-1"></div>
                  <!-- <v-btn color="green darken-1" text @click="item.dialog = false">예약하기</v-btn> -->
                  <v-btn color="green darken-1" text router :to="{name:'reservationNew',params:{roomInfo:rooms[index]}}">예약하기</v-btn>
                  <v-btn color="green darken-1" text @click="item.dialog = false">취소</v-btn>
                  <div class="flex-grow-1"></div>
                </v-card-actions>
              </v-card>
              <!-- card, action 추가하기-->
            </v-dialog>
            <!-- Modal practice-->
            <div class="flex-grow-1"></div>
            <v-btn icon>
              <v-icon>mdi-heart</v-icon>
            </v-btn>
            <v-btn icon>
              <v-icon>mdi-share-variant</v-icon>
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-col>
    </v-row>
  </div>
</template>

<script>
import axios from "axios";
/* eslint-disable */
export default {
  data: function() {
    return {
      rooms: [],
      reservateBtnClick: false,
      roomsImg: []
    };
  },
  methods: {
    getRoomsInfo: function() {
      axios
        .post("/getRooms")
        .then(res => {
          console.log("11", res);
          for (let i = 0; i < res.data.length; i++) {
            res.data[i].dialog = false;
          }
          this.rooms = res.data;
          console.log(this.rooms);
        })
        .catch(err => {
          console.log(err);
        });
    },
    getSeveralImg: function(value) {
      console.log("Hello World!, value = ", value);
      let postdata = new URLSearchParams();
      postdata.append("numb", value);
      axios
        .post("/getRoomsImg", postdata)
        .then(res => {
          console.log("RESss:", res);
          this.roomsImg=res.data;
        })
        .catch(err => {
          console.log(err);
        });
    }
  },
  mounted: function() {
    this.getRoomsInfo();
  }
};
</script>
<style scoped>
</style>