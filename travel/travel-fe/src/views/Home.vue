<template>
  <div class="home">
    <Header />
    <Container />
    <Footer />
  </div>
</template>

<script>
// @ is an alias to /src
import Header from "../components/Header.vue";
import Footer from "../components/Footer.vue";
import Container from "../components/Container.vue";

export default {
  name: "Home",
  components: {
    Header,
    Footer,
    Container,
  },
};
</script>
