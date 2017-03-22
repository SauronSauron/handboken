var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/message/room', function (greeting) {
            showHands(JSON.parse(greeting.body).content);
        });
    });
}

function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}
var counter = -1;
function sendName() {
    counter++;
    stompClient.send("/app/hello", {}, JSON.stringify({'name': '<tr><td>' + $("#name").val() + '</td><td>' + $("#message").val() + '</td><td>' + $("#room").val() + '</td><td>' + '<button id="btn' + counter + '" onclick="getParent(this)">Remove</button>' + '</td></tr>'}));

    //console.log("texten" + JSON.stringify({'name': $("#name").val(), 'message': $("#message").val()}));
}



function getParent(elem) {
    //var parent = elem.parentNode;
    stompClient.send("/app/delete", {}, JSON.stringify({'name': elem.id}));
    //elem.parentNode.parentNode.parentNode.removeChild(elem.parentNode.parentNode);
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});

