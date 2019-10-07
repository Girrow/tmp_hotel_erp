<template>
  <v-container fluid>
    <v-card align="center" style="max-width:960px; margin:50px auto;">
      <v-row>
        <div class="flex-grow-1"></div>
        <v-card-title class="text-center">예약 확인서</v-card-title>
        <div class="flex-grow-1"></div>
      </v-row>
      <hr />
      <v-row>
        <div class="flex-grow-1"></div>
        <v-col cols="12" md="3">예약자 :</v-col>
        <v-col cols="12" md="3">{{this.$store.state.userId}}</v-col>
        <div class="flex-grow-1"></div>
      </v-row>
      <v-row>
        <div class="flex-grow-1"></div>
        <v-col cols="12" md="3">객실 번호 :</v-col>
        <v-col cols="12" md="3">{{this.$route.params.item.no}}</v-col>
        <div class="flex-grow-1"></div>
        <!-- <v-card-text>{{this.$route.params.item}}</v-card-text> -->
      </v-row>
      <v-row>
        <div class="flex-grow-1"></div>
        <v-col cols="12" md="3">예약 가격 :</v-col>
        <v-col cols="12" md="3">{{this.$route.params.item.price}}</v-col>
        <div class="flex-grow-1"></div>
      </v-row>
      <v-row>
        <div class="flex-grow-1"></div>
        <v-col cols="12" md="3">방 정보 :</v-col>
        <v-col
          cols="12"
          md="3"
        >{{this.$route.params.item.roomName}} : {{this.$route.params.item.roomInfo}}</v-col>
        <div class="flex-grow-1"></div>
      </v-row>
      <v-row>
        <div class="flex-grow-1"></div>
        <v-col cols="12" md="3">예약 날짜 :</v-col>
        <v-col cols="12" md="3">예약한날 값</v-col>
        <div class="flex-grow-1"></div>
      </v-row>
      <v-row>
        <v-col>
          <div class="flex-grow-1"></div>
          <v-btn color="primary" router :to="{name:'userInfo'}">확인</v-btn>
          <div class="flex-grow-1"></div>
        </v-col>
      </v-row>
    </v-card>
  </v-container>
</template>

<script>
export default {};
</script>

<style>
</style>