문제 설명
N개의 집이 원형으로 세워져 있는 마을이 있습니다. 각 집에는 1부터 N까지 순서대로 번호가 붙어 있습니다.
이 마을에서 바로 옆에 위치한 집으로 이동하는 데는 1 만큼의 단위 시간이 걸립니다.
또 집과 집 사이를 오가기 위해서는 중간에 위치한 집들을 반드시 거쳐서 이동해야 합니다. 다음은 N = 5인 경우의 예시입니다.

위 그림에서 1번 집에서 2번 집, 또는 5번 집으로 이동하는 데는 1의 시간이 소요됩니다.
또 1번 집에서 3번 집으로 이동하기 위해서는 시계방향으로 2번 집을 거쳐 가거나, 혹은 반시계방향으로 5번과 4번 집을 거쳐서 이동해야 합니다.
따라서 1번 집에서 3번 집으로 이동하는 데는 2 또는 3의 시간이 소요됩니다.
이 마을을 방문한 한 여행자가 현재 1번 집 앞에 있습니다. 이 여행자는 이 마을에 있는 모든 집을 미리 정해진 순서대로 방문하려고 합니다.
예를 들어 위 예시에서 여행자가 미리 방문하기로 한 집의 순서가 [1, 2, 3, 4, 5]라면 
1번 집부터 시계방향으로 각 집을 방문하면 총 4의 단위 시간에 모든 집을 방문할 수 있습니다.
만약 미리 방문하기로 한 집의 순서가 [3, 5, 4, 1, 2]라면 다음과 같은 순서로 모든 집을 방문할 수 있습니다.

여행자는 처음에 1번 집 앞에 있으며, 시계방향으로 2번 집을 거쳐 3번 집으로 이동하면 2의 시간이 소요됩니다.
3번 집에서 시계방향으로 4번 집을 거쳐 5번 집으로 이동하면 2의 시간이 소요됩니다.
5번 집에서 반시계방향으로 4번 집으로 이동하면 1의 시간이 소요됩니다.
4번 집에서 시계방향으로 5번 집을 거쳐 1번 집으로 이동하면 2의 시간이 소요됩니다.
1번 집에서 시계방향으로 2번 집으로 이동하면 1의 시간이 소요됩니다.
위 방법대로 이동하면 총 8의 시간이 소요되며, 이때가 모든 집을 미리 정해진 순서대로 방문하는데 걸리는 시간의 최솟값이 됩니다.

마을에 원형으로 세워져 있는 집의 개수 N과 여행자가 모든 집을 방문하기 위해 미리 정해둔 순서가 들어있는 배열 sequence가 매개변수로 주어질 때,
여행자가 미리 정해둔 순서대로 모든 집을 방문하는 데 필요한 시간의 최솟값을 return 하도록 solution 함수를 완성해주세요.

제한 사항
N은 2 이상 1,000 이하의 자연수입니다.
여행자는 sequence에 들어있는 번호 순서대로 각 집을 방문합니다.
sequence의 길이는 N입니다.
sequence에는 중복된 숫자가 들어있지 않습니다. 즉, 모든 집은 반드시 한 번씩 방문하며, 같은 집을 두 번 이상 방문하지 않습니다.
시간은 집에서 집으로 이동하는데 걸리는 시간만 고려합니다.

입출력 예
N   sequence    result
5   [1,2,3,4,5] 4
5   [3,5,4,1,2] 8

입출력 예 설명
입출력 예 #1
문제의 예시와 같습니다.

입출력 예 #2
문제의 예시와 같습니다.