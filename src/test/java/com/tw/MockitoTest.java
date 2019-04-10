package com.tw;

import org.junit.Test;
import org.mockito.InOrder;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * @author Ruifeng-Wu
 * @Email 296078293@qq.com
 * @date 2019/4/10 10:27
 */
public class MockitoTest {

    @Test
    public void testVerify() throws Exception {
        //mock creation
        List mockedList = mock(List.class);

        //using mock object
        mockedList.add("one");
        mockedList.add("two");
        mockedList.add("two");
        mockedList.clear();

        //验证行为
        verify(mockedList).add("one");//验证是否调用过一次 mockedList.add("one")方法，若不是（0次	或者大于一次），测试将不通过
        verify(mockedList, times(2)).add("two");
        //验证调用过2次 mockedList.add("two")方法，若不是，测试将不通过
        verify(mockedList).clear();//验证是否调用过一次 mockedList.clear()方法，若没有（0次或者大	于一次），测试将不通过


    }

    @Test
    public void testSubbing() throws Exception {
        //你可以mock具体的类，而不仅仅是接口
        LinkedList mockedList = mock(LinkedList.class);

        //Stubbing
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());
        //打印 "first"
        System.out.println(mockedList.get(0));
        //打印 "null" 因为 get(999) 没有设置
        System.out.println(mockedList.get(999));
        //抛runtime exception
        System.out.println(mockedList.get(1));
    }

    @Test
    public void testArgumentMatcher() throws Exception {
        LinkedList mockedList = mock(LinkedList.class);

        //用内置的参数匹配器来stub,如果你使用了参数匹配器，那么所有参数都应该使用参数匹配器
        when(mockedList.get(anyInt())).thenReturn("element");

        //打印 "element"
        System.out.println(mockedList.get(999));

        //你也可以用参数匹配器来验证，此处测试通过
        verify(mockedList).get(anyInt());
        //此处测试将不通过，因为没调用get(33)
        verify(mockedList).get(eq(33));

    }
    @Test
    public void testInvocationTimes() throws Exception {

        LinkedList mockedList = mock(LinkedList.class);

        //using mock
        mockedList.add("once");

        mockedList.add("twice");
        mockedList.add("twice");

        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");

        //下面两个是等价的， 默认使用times(1)
        verify(mockedList).add("once");
        verify(mockedList, times(1)).add("once");

        //验证准确的调用次数
        verify(mockedList, times(2)).add("twice");
        verify(mockedList, times(3)).add("three times");

        //从未调用过. never()是times(0)的别名
        verify(mockedList, never()).add("never happened");

        //用atLeast()/atMost()验证
        verify(mockedList, atLeastOnce()).add("three times");
        //下面这句将不能通过测试
        verify(mockedList, atLeast(2)).add("five times");
        verify(mockedList, atMost(5)).add("three times");
    }

    @Test
    public void testVoidMethodsWithExceptions() throws Exception {

        LinkedList mockedList = mock(LinkedList.class);
        doThrow(new RuntimeException()).when(mockedList).clear();
        //doReturn()|doThrow()| doAnswer()|doNothing()|doCallRealMethod()等用法
        //下面会抛RuntimeException
        mockedList.clear();
    }
    @Test
    public void testVerificationInOrder() throws Exception {
        // A. Single mock whose methods must be invoked in a particular order
        List singleMock = mock(List.class);

        //使用单个mock对象
        singleMock.add("was added first");
        singleMock.add("was added second");

        //创建inOrder
        InOrder inOrder = inOrder(singleMock);

        //验证调用次数，若是调换两句，将会出错，因为singleMock.add("was added first")是先调用的
        inOrder.verify(singleMock).add("was added first");
        inOrder.verify(singleMock).add("was added second");

        // 多个mock对象
        List firstMock = mock(List.class);
        List secondMock = mock(List.class);

        //using mocks
        firstMock.add("was called first");
        secondMock.add("was called second");

        //创建多个mock对象的inOrder
        inOrder = inOrder(firstMock, secondMock);

        //验证firstMock先于secondMock调用
        inOrder.verify(firstMock).add("was called first");
        inOrder.verify(secondMock).add("was called second");
    }
    @Test
    public void testInteractionNeverHappened() {
        List mockOne = mock(List.class);
        List mockTwo = mock(List.class);

        //测试通过
        verifyZeroInteractions(mockOne, mockTwo);

        mockOne.add("");
        //测试不通过，因为mockTwo已经发生过交互了
        verifyZeroInteractions(mockOne, mockTwo);
    }

}
