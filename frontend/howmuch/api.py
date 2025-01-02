import requests

API_BASE__URL = 'https://localhost:8080'

def check_if_user_exists(userName: str):
    try:
        response = requests.get(f'{API_BASE__URL}/api/user/{userName}')
        response.raise_for_status()
        return response.json()
    except requests.exceptions.RequestException as e:
        print(f'Error checking if user {userName} exists: {e}')
        return None

def register_user(userName: str):
    try:
        request_body = {
            'userName': userName
        }
        response = requests.get(f'{API_BASE__URL}/api/user', data=request_body)
        response.raise_for_status()
        print(f'User {userName} registered successfully')
        return True
    except requests.exceptions.RequestException as e:
        print(f'Error registering user {userName}: {e}')
        return None
    
def get_quote(symbol: str):
    try:
        response = requests.get(f'{API_BASE__URL}/api/quote/{symbol}')
        response.raise_for_status()
        return response.json()
    except requests.exceptions.RequestException as e:
        print(f'Error getting quote for {symbol}: {e}')
        return None
    
def add_to_favorites(user_id: float, symbol: str):
    try:
        request_body = {
            "ticker": symbol
        }
        response = requests.post(f'{API_BASE__URL}/api/favorite/{user_id}', data=request_body)
        response.raise_for_status()
        print(f'{symbol} added to favorites for user {user_id}')
        return True
    except requests.exceptions.RequestException as e:
        print(f'Error adding {symbol} to favorites for user {user_id}: {e}')
        return False

def get_favorites(user_id: float):
    try:
        response = requests.get(f'{API_BASE__URL}/api/favorite/{user_id}')
        response.raise_for_status()
        return response.json()
    except requests.exceptions.RequestException as e:
        print(f'Error getting favorites for user {user_id}: {e}')
        return None
    
def get_favorites_quote(user_id: float):
    try:
        response = requests.get(f'{API_BASE__URL}/api/quote/favorites/{user_id}')
        response.raise_for_status()
        return response.json()
    except requests.exceptions.RequestException as e:
        print(f'Error getting favorites quotes for user {user_id}: {e}')
        return None