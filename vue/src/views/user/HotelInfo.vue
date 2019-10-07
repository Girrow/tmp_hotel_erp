<template>
  <v-container fluid>
    <h1 style="text-align:center;">무려 12일 전통을 자랑하는 호텔 소개</h1>
    <v-row>
      <v-col cols="12">
        <v-row :align="'center'" :justify="'center'" class="orange lighten-5" style="min-height:400px!important;">
          <v-card
            class="ma-3 pa-3 text-center"
            outlined
            tile
            img="https://d3s3ousecbrwfp.cloudfront.net/images/2013/10/22100733/cf3ca95363f215e0b15bcaa6d9478883.jpg"
            style="min-height:350px;width:48%;"
          >1대 회장 정하린</v-card>
          <v-card class="ma-3 pa-3 text-center" img="https://www.shillahotels.com/images/en/hub/sub/jejuMainImg.jpg" outlined tile style="min-height:350px;width:48%;">
            그의 인생
            <br />교정시력 1.0 1.0
            <br />두발로 걷고 콧구멍이 두개인 사람
          </v-card>
        </v-row>
      </v-col>
    </v-row>

    <!--  -->
    <!--  -->
    <v-layout row>
      <v-flex xs12 class="text-center display-2 font-weight-black my-5">다양한 조식</v-flex>
    </v-layout>
    <v-layout row wrap class="meal-plans">
      <v-flex xs12 sm12 md4>
        <v-card>
          <v-responsive>
            <v-img src="http://source.unsplash.com/hjCA3ecCXAQ" height="500px">
              <v-container fill-height fluid>
                <v-layout fill-height>
                  <v-flex xs12 align-end flexbox>
                    <span class="headline white--text">KETO</span>
                  </v-flex>
                </v-layout>
              </v-container>
            </v-img>
          </v-responsive>

          <v-card-text>
            <div>
              <h3 class="headline mb-0">Keto</h3>
              <div>비둘기야 밥먹자 구구구구</div>
            </div>
          </v-card-text>

          <v-card-actions v-if="['menu'].includes($route.name)">
            <v-btn
              outline
              block
              color="green"
              @click="showRecipes('keto')"
              data-cy="plansKetoBtn"
            >Select This Plan</v-btn>
          </v-card-actions>
        </v-card>
      </v-flex>

      <v-flex xs12 sm12 md4>
        <v-card>
          <v-responsive>
            <v-img src="http://source.unsplash.com/6S27S6pZ6o0" height="500px">
              <v-container fill-height fluid>
                <v-layout fill-height>
                  <v-flex xs12 align-end flexbox>
                    <span class="headline white--text">PALEO</span>
                  </v-flex>
                </v-layout>
              </v-container>
            </v-img>
          </v-responsive>

          <v-card-text>
            <div>
              <h3 class="headline mb-0">Paleo</h3>
              <div>고추장 된장 초고추장</div>
            </div>
          </v-card-text>

          <v-card-actions v-if="['menu'].includes($route.name)">
            <v-btn
              outline
              block
              color="green"
              @click="showRecipes('paleo')"
              data-cy="plansPaleoBtn"
            >Select This Plan</v-btn>
          </v-card-actions>
        </v-card>
      </v-flex>

      <v-flex xs12 sm12 md4>
        <v-card>
          <v-responsive>
            <v-img src="http://source.unsplash.com/1SPu0KT-Ejg" height="500px">
              <v-container fill-height fluid>
                <v-layout fill-height>
                  <v-flex xs12 align-end flexbox>
                    <span class="headline white--text">VEGAN</span>
                  </v-flex>
                </v-layout>
              </v-container>
            </v-img>
          </v-responsive>

          <v-card-text>
            <div>
              <h3 class="headline mb-0">Vegan</h3>
              <div>토마토는 야채인가 과일인가</div>
            </div>
          </v-card-text>

          <v-card-actions v-if="['menu'].includes($route.name)">
            <v-btn
              outline
              block
              color="green"
              @click="showRecipes('vegan')"
              data-cy="plansVeganBtn"
            >Select This Plan</v-btn>
          </v-card-actions>
        </v-card>
      </v-flex>
    </v-layout>
    <v-row>
      <div class="mapouter mb-7">
        <div class="gmap_canvas">
          <iframe
            id="gmap_canvas"
            width="100%"
            height="500px"
            src="https://maps.google.com/maps?q=구로가츠몽&t=&z=13&ie=UTF8&iwloc=&output=embed"
            frameborder="0"
            scrolling="no"
            marginheight="0"
            marginwidth="0"
          />
        </div>
      </div>
    </v-row>
  </v-container>
</template>

<script>
export default {
  methods: {
    showRecipes(plan) {
      // this.$store.dispatch('getRecipes', plan);
      console.log(plan);
    }
  }
};
</script>

<style scoped>
.mapouter {
  text-align: right;
  /* height: 100%; */
  width: 100%;
  position: absolute;
}
.gmap_canvas {
  overflow: hidden;
  background: none !important;
  /* height: 100%; */
  width: 100%;
}
</style>