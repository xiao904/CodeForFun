LinkedList ���ò�����
    ��ת
    �� kth element
    partition
    ����
    �ϲ�
���ü��ɣ�
    dummy node
    ����ָ��
    ��� ptr(pointer)
	
	swap
	ListNode next = cur.next;
	cur.next = next.next;
	next.next = pre.next;
	pre.next = next;
	pre = cur;
	cur = pre.next;
	
	Reverse
    ///////////
	///head = pre.next;
	///ListNode next = head.next;
	///head.next = next.next;
	///next.next = pre.next;
	///pre.next = next;
	///get tail node
	///////////
	/*ListNode* temp = pre -> next;
      pre -> next = cur -> next;
      cur -> next = cur -> next -> next;
      pre -> next -> next = temp;
	  get tail node;
	*/ 
				
	/* ListNode tail = null;
	   ListNode next = head.next;
       head.next = tail;
       tail = head;				
	   head = next;
	   get head && tail+1 node*/
	
	