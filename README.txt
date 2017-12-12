0. Tutorial

Default package에 있는 ClientMain과 ServerMain이 각각의 main함수를 지니고 있습니다.
현재 local에서 통신하도록 되어있으니 Server를 먼저 켜시고 Client를 켜서 회원가입 후 로그인 하시면 됩니다.
프로젝트에 사용된 이미지는 figures 폴더에 저장되어 있습니다.



1. OCSF

OCSF의 경우 소폭 수정하여 Client가 Request 메시지를 보내면 Server가 Request에 대한 Ack와 함께 원하는 것을 보내주도록 수정하였습니다.
info package의 Message 클래스를 통해서 Client의 Request 메시지와 Server의 Ack 메시지를 보냅니다.
Message 클래스의 Attribute인 Mode를 적절하게 수정하여 서로 간의 프로토콜을 정의하면 됩니다.

프레임워크에 구현된 상황은 다음과 같습니다.

	1. 로그인 시 Client가 본인의 로그인 시도 정보(info.User 객체)를 c모드(Check)로 Request를 보내면,
	Server가 ID와 PW를 확인 후 s 혹은 f모드(Success, Fail)로 Ack합니다.

	2. 회원가입 시 Client가 회원가입 정보(info.User 객체)를 a모드(Append)로 Request를 보내면,
	Server가 해당 정보를 추가한 뒤 s모드(Success)로 Ack합니다.


학생들이 프레임워크를 수정할 시에는 다음과 같은 사항을 고려하면 됩니다.

	1. ServerMain Class의 66번째 라인부터인 handleMessageFromClient 메소드에서 Client로부터의 Request를 적절히 핸들링합니다.

	2. Client 측에서는 Request를 보낼 때 1번에 추가한 사항에 맞게 Message 객체를 보낸 후 바로 Server로부터 오는 Ack Message 객체를 읽으면 됩니다.



2. GUI

2.1 Server

Server의 UI의 경우 단순히 Client 측에서 온 Request를 받을 때 마다 누구로부터 왔는지와 그에 대한 Ack의 정보를 출력합니다.
해당 UI의 TextArea와 stdout(표준출력)을 연결했기 때문에, Server에서 System.out.println() 등으로 표준출력을 하면 로그가 찍히게 됩니다.


2.2 Client

Client의 경우 크게 LoginFrame과 MainFrame이 있습니다.
LoginFrame의 경우 거의 수정할 사항이 없을 것 같고 MainFrame의 경우 Tab을 추가하거나 하는 부분은 해당 Class의 생성자에 주석들을 잘 보고 따라가면 될 것 같습니다.
SearchTabPanel의 경우 가장 복잡한데 마찬가지로 주석을 많이 참고하시면 될 것 같습니다.
GUI 커스터마이징 시에는 WindowBuilder 라는 Eclipse 플러그인을 잘 활용하면 좋을 것 같습니다.
일괄적으로 Default 폰트를 LoginFrame의 43번째 줄에서 수정하고 있는데, 입맛대로 수정하면 될 것 같습니다.