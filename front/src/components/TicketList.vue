<template>
    <ticket_list>
        <TicketNode 
            v-for="ticket in tickets"
            :key="ticket.id"
            :ticket="ticket"
        />
        <TicketNode 
            v-for="ticket in tickets"
            :key="ticket.id"
            :ticket="ticket"
        />
        <TicketNode 
            v-for="ticket in tickets"
            :key="ticket.id"
            :ticket="ticket"
        />
        <TicketNode 
            v-for="ticket in tickets"
            :key="ticket.id"
            :ticket="ticket"
        />
    </ticket_list>
</template>

<script>
import TicketNode from './TicketNode.vue';

export default {
    mounted() {
        const BACKEND_API_HOST_PORT = import.meta.env.VITE_BACKEND_API_HOST_PORT;
        fetch(BACKEND_API_HOST_PORT + "api/v1/tickets")
            .then((response) => response.json())
            .then((data) => this.tickets = data);
    },

    components: {
        TicketNode
    },  

    data() {
        return {
            tickets: []
        };
    },
    components: { TicketNode }
}
</script>

<style>
ticket_list {
    display: flex;
    flex-direction: column;
    justify-content: space-between;
}
</style>