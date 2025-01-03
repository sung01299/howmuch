import requests
import json

API_BASE__URL = 'http://localhost:8080'

def check_if_user_exists(userName: str):
    try:
        response = requests.get(f'{API_BASE__URL}/api/user/{userName}')
        response.raise_for_status()
        return response.json()
    except requests.exceptions.RequestException as e:
        print(f'Error checking if user {userName} exists: {e}')
        exit()

def register_user(userName: str):
    try:
        request_body = {
            'userName': userName
        }
        headers = {
            'Content-Type': 'application/json',
        }

        response = requests.post(f'{API_BASE__URL}/api/user', data=json.dumps(request_body), headers=headers)
        response.raise_for_status()
        return response.json()
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
        headers = {
            'Content-Type': 'application/json',
        }
        response = requests.post(f'{API_BASE__URL}/api/favorites/{user_id}', data=json.dumps(request_body), headers=headers)
        response.raise_for_status()
        return True
    except requests.exceptions.RequestException as e:
        print(f'Error adding {symbol} to favorites for user {user_id}: {e}')
        return False

def get_favorites(user_id: float):
    try:
        response = requests.get(f'{API_BASE__URL}/api/favorites/{user_id}')
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