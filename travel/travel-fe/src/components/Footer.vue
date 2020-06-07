<template>
  <div calss="app">
    <footer>
      <!-- Footer Start-->
      <div
        class="footer-area"
        :style="{'background-image': 'url(' + require('../assets/img/gallery/footer_bg.jpg') + ')'}"
      >
        <div class="container">
          <div class="footer-top footer-padding">
            <div class="row justify-content-between">
              <div class="col-xl-3 col-lg-4 col-md-4 col-sm-6">
                <div class="single-footer-caption mb-50">
                  <div class="single-footer-caption mb-30">
                    <!-- logo -->
                    <div class="footer-logo">
                      <a href="index.html">
                        <img :src="require('../assets/img/logo/logo2_footer.png')" alt />
                      </a>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-xl-2 col-lg-2 col-md-4 col-sm-6">
                <div class="single-footer-caption mb-50">
                  <div class="footer-tittle">
                    <h4>Nhóm thực hiện</h4>
                    <ul>
                      <li>
                        <a href="#">Đạt Ngô</a>
                      </li>
                      <li>
                        <a href="#">Hào Trương</a>
                      </li>
                      <li>
                        <a href="#">Thúy Hiền</a>
                      </li>
                      <li>
                        <a href="#">Đức Tân</a>
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
              <!-- <div class="col-xl-2 col-lg-3 col-md-4 col-sm-6">
                <div class="single-footer-caption mb-50">
                  <div class="footer-tittle">
                    <h4>Categories</h4>
                    <ul>
                      <li>
                        <a href="#">Reasonable Hotel</a>
                      </li>
                      <li>
                        <a href="#">Popular Restaurant</a>
                      </li>
                      <li>
                        <a href="#">Easy Shopping</a>
                      </li>
                      <li>
                        <a href="#">Night Life</a>
                      </li>
                    </ul>
                  </div>
                </div>
              </div>-->
              <!-- <div class="col-xl-3 col-lg-3 col-md-4 col-sm-6">
                <div class="single-footer-caption mb-50">
                  <div class="footer-tittle">
                    <h4>Download App</h4>
                  </div>
                </div>
              </div>-->
            </div>
          </div>
          <div class="footer-bottom"></div>
        </div>
      </div>
      <!-- Footer End-->
    </footer>
  </div>
</template>

<script>
export default {
  name: "footer",
  data() {
    return {};
  },
  methods: {}
};
</script>

<style scoped>
</style>