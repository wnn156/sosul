0. Tutorial

Default package�� �ִ� ClientMain�� ServerMain�� ������ main�Լ��� ���ϰ� �ֽ��ϴ�.
���� local���� ����ϵ��� �Ǿ������� Server�� ���� �ѽð� Client�� �Ѽ� ȸ������ �� �α��� �Ͻø� �˴ϴ�.
������Ʈ�� ���� �̹����� figures ������ ����Ǿ� �ֽ��ϴ�.



1. OCSF

OCSF�� ��� ���� �����Ͽ� Client�� Request �޽����� ������ Server�� Request�� ���� Ack�� �Բ� ���ϴ� ���� �����ֵ��� �����Ͽ����ϴ�.
info package�� Message Ŭ������ ���ؼ� Client�� Request �޽����� Server�� Ack �޽����� �����ϴ�.
Message Ŭ������ Attribute�� Mode�� �����ϰ� �����Ͽ� ���� ���� ���������� �����ϸ� �˴ϴ�.

�����ӿ�ũ�� ������ ��Ȳ�� ������ �����ϴ�.

	1. �α��� �� Client�� ������ �α��� �õ� ����(info.User ��ü)�� c���(Check)�� Request�� ������,
	Server�� ID�� PW�� Ȯ�� �� s Ȥ�� f���(Success, Fail)�� Ack�մϴ�.

	2. ȸ������ �� Client�� ȸ������ ����(info.User ��ü)�� a���(Append)�� Request�� ������,
	Server�� �ش� ������ �߰��� �� s���(Success)�� Ack�մϴ�.


�л����� �����ӿ�ũ�� ������ �ÿ��� ������ ���� ������ ����ϸ� �˴ϴ�.

	1. ServerMain Class�� 66��° ���κ����� handleMessageFromClient �޼ҵ忡�� Client�κ����� Request�� ������ �ڵ鸵�մϴ�.

	2. Client �������� Request�� ���� �� 1���� �߰��� ���׿� �°� Message ��ü�� ���� �� �ٷ� Server�κ��� ���� Ack Message ��ü�� ������ �˴ϴ�.



2. GUI

2.1 Server

Server�� UI�� ��� �ܼ��� Client ������ �� Request�� ���� �� ���� �����κ��� �Դ����� �׿� ���� Ack�� ������ ����մϴ�.
�ش� UI�� TextArea�� stdout(ǥ�����)�� �����߱� ������, Server���� System.out.println() ������ ǥ������� �ϸ� �αװ� ������ �˴ϴ�.


2.2 Client

Client�� ��� ũ�� LoginFrame�� MainFrame�� �ֽ��ϴ�.
LoginFrame�� ��� ���� ������ ������ ���� �� ���� MainFrame�� ��� Tab�� �߰��ϰų� �ϴ� �κ��� �ش� Class�� �����ڿ� �ּ����� �� ���� ���󰡸� �� �� �����ϴ�.
SearchTabPanel�� ��� ���� �����ѵ� ���������� �ּ��� ���� �����Ͻø� �� �� �����ϴ�.
GUI Ŀ���͸���¡ �ÿ��� WindowBuilder ��� Eclipse �÷������� �� Ȱ���ϸ� ���� �� �����ϴ�.
�ϰ������� Default ��Ʈ�� LoginFrame�� 43��° �ٿ��� �����ϰ� �ִµ�, �Ը���� �����ϸ� �� �� �����ϴ�.