Tasking的特点
1.用户前瞻性
2.增量浮现性
3.迭代变更性

![parking-lot](https://user-images.githubusercontent.com/5471228/50380436-1c40fb00-06a2-11e9-8df8-9bd377878e39.gif)


因为停车位是给停车用户使用，所以在设计Tasking的时候，从停车场的用户视角出发

```gherkin
Feature: xxx 
  Scenario: xxx
    Given: 停车场有剩余车位
    When: 取票停车
    Then: 成功进入停车场
    
  Scenario: xxx
    Given: 停车场没有剩余车位
    When: 取票停车
    Then: 无法进入停车场
    
  Scenario: xxx
    Given: 有车停在停车场，且有票
    When: 出票取车
    Then: 成功离开停车场
    
  Scenario: xxx
    Given: 有车停在停车场，没有票
    When: 无票取车
    Then: 无法离开停车场
    
  Scenario: xxx
    Given: 有车停在停车场，车和票不一致
    When: 出票取车
    Then: 无法离开停车场  
  
  Scenario: xxx
    Given: 停车场没有剩余车位
    When: 出票取车
    When: 拿票停车
    Then: 取车成功，停车成功
```

```gherkin
Feature: 停车小弟
  Scenario: xxx
    Given: 停车场A有剩余车位
    When: 小弟停车
    Then: 小弟取票成功
    
  Scenario: xxx
    Given: 车停在停车场A
    When: 小弟拿票取车
    Then: 取车成功
    
  Scenario: xxx
    Given: 车停在停车场A
    When: 司机自己取车
    Then: 取车成功
   
  Scenario: xxx
    Given: 停车场A已满，停车场B有剩余车位
    When: 小弟停车
    Then: 小弟取票成功
    
  Scenario: xxx
    Given: 当车停在停车场B
    When: 小弟取车
    Then: 取车成功
        
  Scenario: xxx
    Given: 车停在停车场B
    When: 司机自己停车
    Then: 取车成功  
    
  Scenario: xxx
    Given: 停车场A和停车场B都已满
    When: 小弟停车
    Then: 停车失败
```

```gherkin
Feature: SmartBoy停车
  Scenario: 
    Given 停车场A有剩余空位
    When SmartBoy停车
    Then SmartBoy停车成功
    
    Given 停车场A没有剩余空位
    When SmartBoy停车
    Then SmartBoy停车失败    
       
    Given 停车场A有2个剩余车位，停车场B有3个剩余车位
    When SmartBoy停车
    Then SmartBoy停车到停车场B   
     
    Given 停车场A有2个剩余车位，停车场B有2个剩余车位
    When SmartBoy停车
    Then SmartBoy停车到停车场A    
    
    Given 停车场A和B都没有停车位
    When SmartBoy停车
    Then SmartBoy停车失败
    
    Given 车停在停车场A，SmartBoy有停车票
    When SmartBoy取车
    Then SmartBoy取车成功
      
    Given 车停在停车场A，SmartBoy有一张非法停车票
    When SmartBoy取车
    Then SmartBoy取车失败

    Given 车停在停车场A，SmartBoy没有停车票
    When SmartBoy取车
    Then SmartBoy取车失败
```

```gherkin
Feature: Parking Manager
  Scenario: 
    Given 有一个Manager，管理一个ParkingBoy
    And ParkingBoy管理一个停车场A，且停车场有空位
    When Manager停车
    Then 停车成功
    
    Given 有一个Manager，管理一个SmartParkingBoy
    And SmartParkingBoy管理一个停车场A，且停车场有空位
    When Manager停车
    Then 停车成功    
    
    Given 有一个Manager，管理一个ParkingBoy和一个SmartParkingBoy
    And ParkingBoy管理一个停车场A，且停车场有空位，SmartParkingBoy管理停车场B，且停车场有空位
    And ParkingBoy先报到
    When Manager停车
    Then ParkingBoy把车停到停车场A          

    Given 有一个Manager，管理一个ParkingBoy和一个SmartParkingBoy
    And ParkingBoy管理一个停车场A，且停车场没有空位，SmartParkingBoy管理停车场B，且停车场有空位
    And ParkingBoy先报到
    When Manager停车
    Then SmartParkingBoy停车成功   
    
    Given 有一个Manager，管理一个ParkingBoy和一个SmartParkingBoy
    And ParkingBoy管理一个停车场A，且停车场没有空位，SmartParkingBoy管理停车场B，且停车场没有空位
    And ParkingBoy先报到
    When Manager停车
    Then Manager停车失败    
    
    Given 有一个Manager，没有小弟
    And 有一个Manager管理一个停车场A，且停车场有空位
    When Manager停车
    Then Manager把车停到停车场A 
    
    Given 有一个Manager，管理一个ParkingBoy和一个SmartParkingBoy
    And ParkingBoy管理一个停车场A，且停车场没有空位，SmartParkingBoy管理停车场B，且停车场没有空位，Manager管理一个停车场C，且停车场有空位
    And ParkingBoy先报到
    When Manager停车
    Then Manager自己停车成功  C       
```