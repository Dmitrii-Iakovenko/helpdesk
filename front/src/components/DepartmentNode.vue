<template>
    <div class="space-y-2.5 p-2.5">
        {{ department.name }}
        <employee-list :employees="department.employees" />
        <div class="p-2.5 border rounded border-grid"
            v-for="child in department.child" :key="child.department_id">
            <department-node :department="child" />
        </div>
    </div>
</template>


<script>
import EmployeeList from './EmployeeList.vue'


export default {
    components: {
        EmployeeList
    },

    props: {
        department: {
            type: Object,
            required: true
        }
    }
}
</script>
