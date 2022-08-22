<template>
    <div  class="space-y-2.5 p-2.5" >
        <h2>Список департаментов:</h2>
        <div class="p-2.5 border rounded border-grid"
            v-for="department in departments" :key="department.department_id">
            {{ department.name }}
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            departments: [],
        }
    },

    mounted() {
        fetch("http://localhost:8080/api/v1/departments")
        .then((response) => response.json())
        .then((data) => this.departments = data);        
    }
}
</script>
