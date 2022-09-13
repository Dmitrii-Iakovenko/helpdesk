<template>
    <ticket_node>
        <created>{{ ticket.created }}</created>
        <employee>
            {{ ticket.employee.lastName }}
            {{ ticket.employee.firstName }}
            {{ ticket.employee.middleName }}
        </employee>
        <category>{{ ticket.category }}</category>
        <engineer>
            {{ ticket.engineer.lastName }}
            {{ ticket.engineer.firstName }}
            {{ ticket.engineer.middleName }}
        </engineer>
    </ticket_node>
</template>

<script>
export default {
    props: {
        ticket: {
            type: Object,
            required: true
        }
    },
}
</script>

<style>
ticket_node {
    display: flex;
    flex-direction: row;
    /* justify-content: space-between; */

    /* flex-wrap: wrap; */
    background-color: rgb(255 255 255);
    border-bottom-width: 1px;
    
    /* height: 400px;
    align-content: space-between; */
}

ticket_node * {
    /* padding: 10px; */
    font-weight: 500;
    color: rgb(17 24 39);
    /* white-space: nowrap; */
    border-width: 1px;
    flex: 1 1 auto;

}

.dark ticket_node {
    background-color: rgb(31 41 55);
    border-color: rgb(55 65 81);
}

.dark ticket_node * {
    color: rgb(190, 190, 190);
}
</style>