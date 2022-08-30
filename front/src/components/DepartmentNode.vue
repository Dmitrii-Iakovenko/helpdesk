<template>
    <tr><th class="pt-5 pb-2 px-5 border border-grid" colspan="7">{{ department.name }}</th></tr>
    <employee-node 
        v-for="employee in department.employees" 
        :key="employee.employeeId" 
        :employee="employee" 
    />
    <department-node 
        v-for="child in department.child" 
        :key="child.department_id"
        :department="child"
    />
</template>


<script>
import EmployeeNode from './EmployeeNode.vue'


export default {
    components: {
        EmployeeNode
    },

    props: {
        department: {
            type: Object,
            required: true
        }
    }
}
</script>
