<template>
  <header class="sticky z-20 top-0 left-0 ">
    <nav-bar />
  </header>
  <main>
    <ticket-list />
  </main>
  <footer></footer>
</template>


<script>
import DepartmentTree from './components/DepartmentTree.vue'
import NavBar from './components/NavBar.vue'
import TicketList from './components/TicketList.vue'


export default {
  name: "App",

  components: {
    DepartmentTree, 
    NavBar,
    TicketList
  },

  data() {
    return {

    }
  }, 

}
</script>

