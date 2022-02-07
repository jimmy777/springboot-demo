var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);

    if (connected) {
        $("#conversation").show();
        $("#chat").show();
    } else {
      $("#conversation").hide();
      $("#chat").hide();
    }
    $("#greetings").html("");
}

function connect() {
    if (!$("#name").val()) {
        return;
    }

    // 创建一个stomp实例，建立websocket连接。注意websocket的config中对/chat进行了声明。
    const socket = new SockJS('/chat');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function () {
        setConnected(true);
        // 订阅服务端发送回来的消息
        stompClient.subscribe('/topic/greetings', function (greeting) {
            // 展示消息
            showGreeting(JSON.parse(greeting.body));
        })
    })
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
}

function sendName() {
    stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val(), 'content': $("#content").val()}));
}

function showGreeting(message) {
    $("#greetings").append("<div>" + message.name + ":" + message.content + "<div>");
}

$(function () {
    $("#connect").click(function () {
        connect();
    });
    $("#disconnect").click(function () {
        disconnect();
    });
    $("#send").click(function () {
       sendName();
    });
});