<template>
    <tr>
        <td class="py-0 px-2 border border-grid">{{ employee.jobPosition }}</td>
        <td class="py-0 px-2 border border-grid">{{ employee.lastName }} {{ employee.firstName }} {{ employee.middleName }}</td>
        <td class="py-0 px-2 border border-grid">{{ employee.cityPhone }}</td>
        <td class="py-0 px-2 border border-grid">{{ employee.localPhone }}</td>
        <td class="py-0 px-2 border border-grid">{{ employee.workLocation }}</td>
        <td class="py-0 px-2 border border-grid">{{ employee.mobilePhone }}</td>
        <td class="py-0 px-2 border border-grid">{{ employee.email }}</td>
    </tr>
</template>


<script>
export default {
    props: {
        employee: {
            type: Object,
            required: true
        }
    }
}
</script>