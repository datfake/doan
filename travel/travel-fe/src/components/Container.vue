<template>
  <div class="app">
    <main>
      <!-- Popular Locations Start -->
      <div class="popular-location section-padding30">
        <div class="container">
          <div class="row">
            <div class="col-lg-12">
              <!-- Section Tittle -->
              <div class="section-tittle text-center mb-50">
                <span>Địa điểm hot</span>
                <!-- <h2>Popular Locations</h2> -->
              </div>
            </div>
          </div>
          <div class="row">
            <div
              class="col-lg-4 col-md-6 col-sm-6"
            >
              <div class="single-location mb-30">
                <div class="location-img">
                  
                </div>
                <div class="location-details">
                  
                  <a href="#" class="location-btn">
                    <i class="ti-plus"></i>
                    
                  </a>
                </div>
              </div>
            </div>
          </div>
          <!-- More Btn -->
          <div class="row justify-content-center">
            <div class="room-btn pt-20">
              <a href="catagori.html" class="btn view-btn1">Xem tất cả</a>
            </div>
          </div>

          <div class="container">
            <div class="row">
              <div class="col-lg-12">
                <div class="write-post" v-if="getToken.token">
                  <div class="select-box">
                    <label for="select-box1" class="label select-box1">
                      <span class="label-desc">{{title}}</span>
                    </label>
                    <select id="select-box1" class="select" @change="onChange()" v-model="selected">
                      <option
                       
                      
                    </select>
                  </div>
                  <div>
                    <textarea
                      id="textarea"
                      v-model="content"
                      placeholder="Bạn đang nghĩ gì!"
                      rows="5"
                      max-rows="10"
                    ></textarea>
                  </div>
                  <a href="#"  class="action-button shadow animate blue">Review</a>
                </div>
                <hr />
                <div class="container_post-list" >
                  <div class="user-writepost">
                    <a href class="avatar">
                      <img
                        class="img-avatar"
                        :src="require('../assets/img/gallery/avatar.jpg')"
                        alt
                      />
                    </a>             
                  <div class="img_post-content">
                  </div>
                  <div class="post-commment">
                    <textarea name="comment" v-model="textComment" class="form-control" rows="2"></textarea>
                    <button  class="btn-comment">Bình Luận</button>
                    <ul
                      class="comments"
                    >
                      <li class="clearfix">
                        <img src="https://bootdey.com/img/Content/user_1.jpg" class="avatar" alt />
                        <div class="post-comments">
                          <p class="meta">
                          </p>
                        </div>
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <!-- Popular Locations End -->

      <!-- Categories Area Start -->

      <!-- Blog Ara End -->
    </main>
  </div>
</template>

<script>
export default {
}
</script>

<style scoped>
.post-comments {
  margin-left: 12px;
}
li.clearfix {
  display: flex;
  margin-top: 12px;
}
button.btn-comment {
  margin-top: 8px;
  border: none;
  color: #dee2e6;
  background-color: rgba(0, 123, 255, 0.5);
  border-radius: 8px;
}
input:focus,
select:focus,
textarea:focus,
button:focus {
  outline: none;
}
textarea[data-v-49781c01] {
  min-height: 60px;
}
.post-commment {
  padding: 24px;
  margin-top: 12px;
}
.img_post-content {
  text-align: center;
}

.img-avatar {
  width: 45px;
  border-radius: 90%;
}
span.user_post {
  margin: auto 12px;
  font-weight: 700;
  color: #2e2d8a;
}

.container_post-list {
  border: 2px solid #444;
  border-radius: 2px;
}

.post-content {
  padding: 5px;
}

hr {
  margin-top: 80px;
}

.user-writepost {
  display: flex;
  padding: 8px;
}

textarea {
  width: 100%;
  min-height: 100px;
  resize: none;
  border-radius: 8px;
  border: 1px solid #ddd;
  padding: 0.5rem;
  color: #666;
  box-shadow: inset 0 0 0.25rem #ddd;
}

.select-box {
  cursor: pointer;
  position: relative;
  max-width: 20em;
  margin-top: 4em;
  margin-bottom: 1em;
  width: 100%;
}

.select,
.label {
  color: #414141;
  display: block;
  font: 400 17px/2em "Source Sans Pro", sans-serif;
}

.select {
  width: 100%;
  position: absolute;
  top: 0;
  padding: 5px 0;
  height: 40px;
  opacity: 0;
  -ms-filter: "progid:DXImageTransform.Microsoft.Alpha(Opacity=0)";
  background: none transparent;
  border: 0 none;
}
.select-box1 {
  background: #ececec;
  background-color: #1c77ff;
  color: #fff;
}

.label {
  position: relative;
  padding: 5px 10px;
  cursor: pointer;
}
.open .label::after {
  content: "▲";
}
.label::after {
  content: "▼";
  font-size: 12px;
  position: absolute;
  right: 0;
  top: 0;
  padding: 5px 15px;
  border-left: 5px solid #fff;
}

label.label.select-box1 {
  border-radius: 8px;
}
/*mobile & tablet */
@media (max-width: 1023px) {
  .hide-on-mobile-tablet {
    display: none;
  }
}

/* tablet */
@media (min-width: 740px) and (max-width: 1023px) {
  .hide-on-tablet {
    display: none;
  }
}

@media (max-width: 739px) {
  .hide-on-mobile {
    display: none;
  }
}

.action-button {
  position: relative;
  padding: 10px 40px;
  margin: 0px 10px 10px 0px;
  float: left;
  border-radius: 10px;
  font-family: "Pacifico", cursive;
  font-size: 25px;
  color: #fff;
  text-decoration: none;
}

.blue {
  background-color: #3498db;
  border-bottom: 5px solid #2980b9;
  text-shadow: 0px -2px #2980b9;
}

.action-button:active {
  transform: translate(0px, 5px);
  -webkit-transform: translate(0px, 5px);
  border-bottom: 1px solid;
}
</style>